
public class StructNode {
	
	public String company;
	public int ownedShares;
	public float sharePrice;
	public StructNode next;

	public StructNode(String companyName, int numberOfShares, float price)
	{
		company = companyName;
		ownedShares = numberOfShares;
		sharePrice = price;
		next = null;
	}
}
