

public class Account
{

	String username;
	double balance;
	StructNode root;
	StructNode current;
	
	
	public Account (String name, double bal)
	{

		username = name;
		balance = bal;
		
		root = new StructNode("root", 0, 0.0);
		current = root;
		
	}
	
	
	public void add(String comp, int num, double price)
	{
		while(current.next != null)
		{
			current = current.next;
		}
		
		StructNode newNode = new StructNode(comp, num, price);
		current.next = newNode;
	}
	
	public void buy(String comp, int owned, double price)
	{
		boolean found = false;
		current = root;
		balance -= (owned * price);
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
	
	public void sell(String comp, int owned, double pri)
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
				balance += pri;
			}
		}
		
		if (found == false)
		{
			System.out.println("You do not own any of this stock!");
		}
		
	}
	
	public void display()
	{
		System.out.println("Username: " + username);
		System.out.println("Balance: " + balance);
		current = root;
		while(current.next != null)
		{
			current = current.next;
			System.out.println("Company: " + current.company);
			System.out.println("You own: " + current.ownedShares);
			System.out.println("Price: " + current.sharePrice);
		}
	}
}
