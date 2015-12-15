import java.net.*;
import java.io.*;

public class ReceiveMessages implements Runnable
{
	
	Socket clientSocket;
	BufferedReader in;
	public String inputText;
	public static String sID;
	
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
	
	public void receiveMessage()
	{
		try
		{
			 
			while((inputText = in.readLine()) != null)
			{
					System.out.println("Client: " + clientSocket.getLocalSocketAddress() + " : " + inputText);
				
			}
		}
		catch(IOException e)
		{
			System.out.println("An error happened: " + e);
		}	
	}

	public void run()
	{
		while(true)
		{
			receiveMessage();	
		}
	}	
	
	public String getrID()
	{
		sID = clientSocket.getLocalSocketAddress().toString();
		return sID;
	}
}
