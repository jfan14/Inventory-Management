import java.util.Scanner;
import java.util.ArrayList;


public class InventoryClient {
	public static void main(String [] args) {
		ArrayList <Inventory> list = new ArrayList<>(); //I will be using array list to store the object
		char flag2 = 'Y'; //This one I wanted to do like if you press certain key to stop the process, but it is not required in instruction
		while(flag2 != 'N') {
			System.out.println("Enter command"); // User's instruction
			Scanner scan = new Scanner(System.in);  //Make a scanner object
			String command = scan.nextLine(); //Read in command
			String [] token; //Tokenize the command token[0] will be the {create/updateBuy/updateSell/delete/report}
			token = command.split(" "); // Split by empty space to get tokens
			if(token[0].equals("create")) { //compare token[0]
				Inventory i = new Inventory(token[1], Double.parseDouble(token[2]), Double.parseDouble(token[3])); // token[1] is item name, token[2] is bought at, token[3] is sell at
				list.add(i); // add object into array list
			}else if(token[0].equals("updateBuy")) { //another compare
				if(list.size() > 0) { //first you have to have object in it then you can update buy
					for(int i=0;i<list.size();i++) { //loop through array list
						if(list.get(i).getItemName().equals(token[1])) { //compare the item user want to add and item existed in array list 
							list.get(i).setAvailability(list.get(i).getAvailability() + Integer.parseInt(token[2])); //token[2] is a String, we want to parse it to int
							list.get(i).setBuyAmount(Integer.parseInt(token[2]));
							continue; // If we have that in array list, ho ray, update
						}
					}
				}else {
					System.out.println("No inventory right now, please create first"); //size is 0, cannot update
					continue;
				}
			}else if(token[0].equals("updateSell")) { //compare it with updateSell
				if(list.size() > 0) { //size > 0 is a must, if we don't have that item even, not mention we sell it
					for(int i=0;i<list.size();i++) { //loop through arraylist
						if(list.get(i).getItemName().equals(token[1])) {
							if(list.get(i).getAvailability() > Integer.parseInt(token[2])) { //The availability must bigger than sell amount, no way you only have 5 pens and sell 10 pens to customer
								list.get(i).setSellAmount(Integer.parseInt(token[2]));
								list.get(i).setAvailability(list.get(i).getAvailability() - Integer.parseInt(token[2])); //update the availability
								continue;
							}else {
								System.out.println("Not sufficient amount, do updateBuy command first"); //warn user that we don't have sufficient amount
								continue;
							}
						}
					}
				}else {
					System.out.println("No inventory right now, please create first"); 
					continue;
				}
			}else if(token[0].equals("delete")) { //Compare token with delete
				if(list.size() > 0) {
					for(int i=0;i<list.size();i++) {
						if(list.get(i).getItemName().equals(token[1])) {
							list.remove(i); // We simply remove the object from the array list
							continue;
						}
					}
				}else {
					System.out.println("Inventory is empty"); 
					continue;
				}
				
			}else if(token[0].equals("report")) { // compare again
				Inventory i = new Inventory();
				System.out.println(i.toString(list)); //print out the table-like String in toString method
				for(int j=0;j<list.size();j++) {
					list.get(j).setBuyAmount(0);
				}
			}else {
				System.out.println("Command not found");
			}
		}
	}
}
