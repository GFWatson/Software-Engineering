
public class StructNode {
	
	public String company;
	public int ownedShares;
	public double sharePrice;
	public StructNode next;

	public StructNode(String companyName, int numberOfShares, double price)
	{
		company = companyName;
		ownedShares = numberOfShares;
		sharePrice = price;
	}
	
}
