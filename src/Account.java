

public class Account
{

	String username;
	String password;
	String serverID;
	double balance;
	StructNode root;
	StructNode current;
	
	
	public Account (String name, String pass, String id)
	{

		String username;
		String password;
		String serverID;
		float balance;
		
		root = new StructNode("root", 0, 0.0);
		current = root;
		
	}
	
	public void add(String comp, int num, float price)
	{
		while(current.next != null)
		{
			current = current.next;
		}
		
		StructNode newNode = new StructNode(comp, num, price);
		current.next = newNode;
	}
	
	public void change(String comp, int owned, double price)
	{
		boolean found = false;
		current = root;
		while(current.next != null)
		{
			current = current.next;
			if(current.company.equals(comp))
			{
				found = true;
				current.ownedShares += owned;
				current.sharePrice = price;
			}
		}
		
		if (found == false)
		{
			add(comp, owned, price);
		}
		
	}
	
	
}
