
public class StructNode {
	
	public String company;
	public int ownedShares;
	public double sharePrice;
	public StructNode next;

	//constructor
	//holds info of shares and next node
	public StructNode(String companyName, int numberOfShares, double price)
	{
		company = companyName;
		ownedShares = numberOfShares;
		sharePrice = price;
		next = null;
	}
}
