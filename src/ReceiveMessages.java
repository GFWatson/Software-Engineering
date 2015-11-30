import java.net.*;
import java.io.*;

public class ReceiveMessages implements Runnable
{
	
	Socket clientSocket;
	BufferedReader in;
	String inputText;
	
	public ReceiveMessages(Socket aSocket)
	{

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
	
	public String getText()
	{
		return inputText;
	}
}
