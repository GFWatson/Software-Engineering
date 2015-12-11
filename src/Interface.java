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
	String numberOfSharesB;
	String numberOfSharesS;

	
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
			}
			
			userIn = stdIn.readLine().toUpperCase();
			
			if(userIn.equals("BUY"))
			{
				buy(stdIn);
			}
			
			else if(userIn.equals("SELL"))
			{
				sell(stdIn);
			}
			
			else if(userIn.equals("DISP"))
			{
				disp(stdIn);
			}
			//will become a switch case for all actions
			
			}
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
	}
	
	private void regi(BufferedReader reader)
	{
		String accountName;
		String password;
		
		try
		{
		System.out.println("Enter your Name: \n");
		accountName = reader.readLine().toUpperCase();
			
		System.out.println("Enter a secure password for ID: \n");
		password = reader.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		sM.setText("REGI");
		System.out.println("should have sent regi!");
		
		
		secretID = rM.getText();
		
		sM.setText("");
		rM.getText();		
		 ActualID = rM.getrID().substring(Math.max(rM.getrID().length() - 5, 0));
		System.out.println("Your Secret ID is: " + ActualID);

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
		
		if(companyName.equals("MICROSOFT"))
		{
			companyName = "Microsoft";
		}
		else if(companyName.equals("GOOGLE"))
		{
			companyName = "Google";
		}
		//the other companies need adding
		//and then this needs adding to the sell function
		try
		{
		System.out.println("Enter number of shares: ");
		numberOfSharesB = stdIn.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		sM.setText("BUY:" + companyName + ":" + numberOfSharesB + ":" + ActualID);
		System.out.println(rM.getText());
		
		if(rM.getText().toString() != "")
		{
		String purchasePrice = rM.getText().toString();
		System.out.println("You purchased at this rate: " + purchasePrice);
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
		
		if(companyName == "MICROSOFT")
		{
			companyName = "Microsoft";
		}
		else if(companyName == "GOOGLE")
		{
			companyName = "Google";
		}
		//the other companies need adding
		//and then this needs adding to the sell function
		try
		{
		System.out.println("Enter number of shares: ");
		numberOfSharesS = stdIn.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		sM.setText("SELL:" + companyName + ":" + numberOfSharesS + ":" + ActualID);
		System.out.println(rM.getText());
	}
	
	private void disp(BufferedReader stdIn)
	{
		System.out.println("ID: " + ActualID);
		System.out.println("Company: " + companyName);
		System.out.println("Shares bought: " + numberOfSharesB);
		System.out.println("Shares sold: " + numberOfSharesS);
	}
}
	

