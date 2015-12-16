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

	//constructor
	public Interface(ReceiveMessages myRM, SendMessages mySM)
	{
		rM = myRM;
		sM = mySM;
	}
	//run method for thread
	public void run()
	{
		getInput();
	}
	
	//get user input and process
	private void getInput()
	{
		try
		{
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			//log in when program starts
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
			
			//process commands
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
	
	//create account
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
		//register with server
		sM.setText("REGI");				
		ActualID = rM.getrID().substring(Math.max(rM.getrID().length() - 5, 0));
		System.out.println("Your Secret ID is: " + ActualID);
		myAccount = new Account(accountName, 10000.0);
		loggedIn = true;
		
	}
	
	//buy shares
	private void buy(BufferedReader stdIn)
	{
		//get transaction details
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
		
		//send buy command to server
		sM.setText("BUY:" + companyName + ":" + numberOfShares + ":" + ActualID);
		
		//user input of details sent back
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
				//changes to account
				myAccount.buy(companyName, num, pri);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//sell shares
	private void sell(BufferedReader stdIn)
	{
		//get transaction details
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
		
		//send sell command to server
		sM.setText("SELL:" + companyName + ":" + numberOfShares + ":" + ActualID);
		
		//user input of details sent back
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
				//changes to account
				myAccount.sell(companyName, num, pri);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	//display account details
	private void disp(BufferedReader stdIn)
	{
		myAccount.display();
	}
	//display current server shares
	private void disps(BufferedReader stdIn)
	{
		sM.setText("DISP");
	}
	
}
	

