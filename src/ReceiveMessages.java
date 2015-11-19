import java.net.*;
import java.io.*;

public class ReceiveMessages implements Runnable
{
	
	Socket clientSocket;
	BufferedReader in;
	static String inputText;
	
	public ReceiveMessages(Socket aSocket)
	{
		clientSocket = aSocket;
	}	
	
	public void run()
	{
		try
		{
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			 
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
	
}
