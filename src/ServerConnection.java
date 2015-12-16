import java.io.*;
import java.net.*;

public class ServerConnection
{

	public static void main(String[] args)
	{
		//create server connection
		ServerConnection myServerConnection = new ServerConnection();
		//run threads
		myServerConnection.initialiseThreads();
	}
	
	public void initialiseThreads()
	{

		try{
			//create socket to pass use for sending and receiving
			Socket clientSocket = new Socket("192.168.0.48", 5000);
			
			//create and run threads
			ReceiveMessages myRM = new ReceiveMessages(clientSocket);
			SendMessages mySM = new SendMessages(clientSocket);
			Interface myInterface = new Interface(myRM, mySM);
			
			Thread t1 = new Thread(myRM);
			Thread t2 = new Thread(mySM);
			Thread t3 = new Thread(myInterface);

			t1.start();
			t2.start();
			t3.start();
			

		
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}