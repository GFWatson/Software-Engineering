import java.net.*;
import java.io.*;

public class SendMessages implements Runnable{
	
	Socket clientSocket;
	PrintWriter out;
	static String userInput;
	
	public SendMessages(Socket aSocket)
	{
		clientSocket = aSocket;
	}
	
	public void run()
	{

		try
		{
			out = new PrintWriter(clientSocket.getOutputStream(), true);

			while (userInput != null)
			{
				out.println(userInput);
			}	
		}
		catch (IOException e)
		{
			System.out.println("An error happened: " + e);
		}
	}
	
}