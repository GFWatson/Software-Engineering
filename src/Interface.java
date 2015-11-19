import java.io.*;

public class Interface implements Runnable{
	
	String userIn;
	String serverOut;
	boolean loggedIn = false;
	String currentUser;
	
	public Interface()
	{
		
	}
	
	public void run()
	{
		try
		{
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			userIn = stdIn.readLine().toUpperCase();
			serverOut = ReceiveMessages.inputText;
			
			if(loggedIn == false)
			{
				register(stdIn);
			}
			else
			{
				System.out.println("What would you like to do?");
			}
			
			if(userIn == "BUY")
			{
				//buy();
			}
			else if(userIn == "SELL")
			{
				//sell();
			}
			//will become a switch case for all actions
			
			
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
	}
	
	private void register(BufferedReader reader)
	{
		String accountNum;
		String password;
		
		try
		{
			do
			{
			System.out.println("Please enter your account number: ");
			accountNum = reader.readLine().toUpperCase();
			//check to see if there's an account for that number
			//if there is:
				do
				{
					System.out.println("Please enter the account password: ");
					password = reader.readLine().toUpperCase();
					//check to see if password matches account
					//if not, password = "wrong"
				}
				while(password != "wrong");
			//if not:
				//System.out.println("There is no account for that number. Would you like to register?");
				//userIn = reader.readLine().toUpperCase();
				//if(userIn == "YES")
					//System.out.println("Please enter a password: ");
					//password = reader.readLine().toUpperCase();
					//create account using accountNum and password
			//else accountNum = "wrong";
			}
			while(accountNum != "wrong");
			
			//get unique code for account
			//currentUser = uniqueCode
			loggedIn = true;
			
		}
		catch(IOException e)
		{
			System.out.println("There has been an error: " + e);
		}
	}
	
	
	
}
