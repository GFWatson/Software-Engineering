import java.io.*;

public class Interface implements Runnable{
	
	String userIn;
	String userInfo;
	String serverOut;
	boolean loggedIn = false;
	String currentUser;
	String secretID;
	ReceiveMessages rM;
	SendMessages sM;
	String ActualID;
	String companyName;
	String numberOfShares;
	Account myAccount;

	
	public Interface(ReceiveMessages myRM, SendMessages mySM)
	{
		rM = myRM;
		sM = mySM;
	}
	
	public void run()
	{
		getInput();
	}
	
	private void getInput()
	{
		try
		{
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			
			while(true)
			{
			if(loggedIn == false)
			{
			regi(stdIn);
				
			}
			else
			{
				System.out.println("What would you like to do?");
				userIn = stdIn.readLine().toUpperCase();
			}
			
			
			if(userIn.equals("BUY"))
			{
				buy(stdIn);
			}
			
			else if(userIn.equals("SELL"))
			{
				sell(stdIn);
			}
			
			else if(userIn.equals("DISPA"))
			{
				disp(stdIn);
			}
			else if (userIn.equals("DISPS"))
			{
				disps(stdIn);
			}
			
			}
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
	}
	
	private void regi(BufferedReader reader)
	{
		String accountName = "";
		
		try
		{
		System.out.println("You must create an account.");
		System.out.println("Enter your Name:");
		accountName = reader.readLine().toUpperCase();
		System.out.println("You have a balance of £10000.00");
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		sM.setText("REGI");				
		ActualID = rM.getrID().substring(Math.max(rM.getrID().length() - 5, 0));
		System.out.println("Your Secret ID is: " + ActualID);
		myAccount = new Account(accountName, 10000.0);
		loggedIn = true;
		
	}
	
	private void buy(BufferedReader stdIn)
	{
		try
		{
		System.out.println("Enter the company name: ");
		companyName = stdIn.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		try
		{
		System.out.println("Enter number of shares: ");
		numberOfShares = stdIn.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		sM.setText("BUY:" + companyName + ":" + numberOfShares + ":" + ActualID);
		System.out.println("Please enter \"Y\" if transaction was successful:");
		
		try
		{
			String input = stdIn.readLine().toUpperCase();
			if(input.equals("Y"))
			{
				System.out.println("Please enter the price you bought the share for:");
				String price = stdIn.readLine().toUpperCase();
				int num = Integer.parseInt(numberOfShares);
				double pri = Double.parseDouble(price);
				myAccount.buy(companyName, num, pri);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void sell(BufferedReader stdIn)
	{
		try
		{
		System.out.println("Enter the company name: ");
		companyName = stdIn.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		try
		{
		System.out.println("Enter number of shares: ");
		numberOfShares = stdIn.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		sM.setText("SELL:" + companyName + ":" + numberOfShares + ":" + ActualID);
		System.out.println("Please enter \"Y\" if transaction was successful:");
		
		try
		{
			String input = stdIn.readLine().toUpperCase();
			if(input.equals("Y"))
			{
				System.out.println("Please enter how much you made in this sale:");
				String price = stdIn.readLine().toUpperCase();
				int num = Integer.parseInt(numberOfShares);
				double pri = Double.parseDouble(price);
				myAccount.sell(companyName, num, pri);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void disp(BufferedReader stdIn)
	{
		myAccount.display();
	}
	
	private void disps(BufferedReader stdIn)
	{
		sM.setText("DISP");
	}
	
}
	

