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

		loggedIn = true;

	}
	
	private void buy(BufferedReader stdIn)
	{
		String companyName = "";
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
		String numberOfShares = "";
		try
		{
		System.out.println("Enter number of shares: ");
		numberOfShares = stdIn.readLine().toUpperCase();
		//shareNumber = Integer.valueOf(inputSecretID);
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		sM.setText("BUY:" + companyName + ":" + numberOfShares + ":" + secretID);
		System.out.println(rM.getText());
	}
	
	private void sell(BufferedReader stdIn)
	{
		String companyName = "";
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
		String numberOfShares = "";
		try
		{
		System.out.println("Enter number of shares: ");
		numberOfShares = stdIn.readLine().toUpperCase();
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
		
		sM.setText("SELL:" + companyName + ":" + numberOfShares + ":" + secretID);
		System.out.println(rM.getText());

	}
}
	

