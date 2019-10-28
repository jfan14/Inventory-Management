import java.util.ArrayList;

public class Inventory {
	private String itemName;
	private double boughtAt;
	private double soldAt;
	private int availability;
	private int buyAmount; //amount we bought
	private int sellAmount; //amount we sell
	
	public Inventory() { //default constructor with no argument, convenient for instantiate
		
	}
	
	public Inventory(int new_availability) { // for updateBuy command
		itemName = "";
		boughtAt = 0.0;
		soldAt = 0.0;
		availability = new_availability;
	}
	
	public Inventory(String new_itemName, double new_boughtAt, double new_soldAt) { //for create command
		itemName = new_itemName;
		boughtAt = new_boughtAt;
		soldAt = new_soldAt;	
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getBoughtAt() {
		return boughtAt;
	}

	public void setBoughtAt(double boughtAt) {							//SETTER AND GETTER nothing fancy
		this.boughtAt = boughtAt;
	}

	public double getSoldAt() {
		return soldAt;
	}

	public void setSoldAt(double soldAt) {
		this.soldAt = soldAt;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	public void setSellAmount(int sellAmount) {
		this.sellAmount = sellAmount;
	}
	
	public int getSellAmount() {
		return this.sellAmount;
	}
	
	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}
	
	public int getBuyAmount() {
		return buyAmount;
	}
	
	
	
	public String toString(ArrayList<Inventory> l) { // This is the toString, I have to admit that i spent most of time to make it looks good lol
		String ret = "";
		double totalValue = 0.0;
		double netProfit = 0.0;
		for(int i=0;i<l.size();i++) {
			totalValue += l.get(i).getAvailability() * l.get(i).getBoughtAt();
			netProfit += l.get(i).getSoldAt()* l.get(i).getSellAmount() - (l.get(i).getBuyAmount() * l.get(i).getBoughtAt());
			ret += l.get(i).getItemName() + "\t\t" + l.get(i).getBoughtAt() + "\t\t" + l.get(i).getSoldAt() + "\t\t" + l.get(i).getAvailability() + "\t\t" + l.get(i).getAvailability() * l.get(i).getBoughtAt() +"\n";
		}
		return "Item Name" + "\t" + "Bought At" + "\t" + "Sold At" + "\t\t" + "AvailableQty" + "\t" + "Value\n" 
			 + "---------" + "\t" + "---------" + "\t" + "-------" + "\t\t" + "------------" + "\t" + "-----\n"
			 + ret + "\n"
			 + "--------------------------------------------------------------------------------------------\n"
			 + "Total Value" + "\t\t\t\t\t\t\t" + totalValue + "\n"
			 + "Profit since previous report" + "\t\t\t\t\t" + netProfit + "\n";                                                                        
	}
	
	
}
