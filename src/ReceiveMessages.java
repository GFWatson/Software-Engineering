import java.net.*;
import java.io.*;

public class ReceiveMessages implements Runnable
{
	
	Socket clientSocket;
	BufferedReader in;
	public String inputText;
	public static String sID;
	
	//constructor
	//creates buffered reader to receive messages from server
	public ReceiveMessages(Socket aSocket)
	{
		clientSocket = aSocket;
		try
		{
			in = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
	//prints messages from server to console
	public void receiveMessage()
	{
		try
		{
			while((inputText = in.readLine()) != null)
			{
					System.out.println(inputText);
			}
		}
		catch(IOException e)
		{
			System.out.println("An error happened: " + e);
		}	
	}
	//run method for thread
	public void run()
	{
		while(true)
		{
			receiveMessage();	
		}
	}	
	//get server id
	public String getrID()
	{
		sID = clientSocket.getLocalSocketAddress().toString();
		return sID;
	}
}
