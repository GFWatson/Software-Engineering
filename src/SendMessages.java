import java.net.*;
import java.io.*;

public class SendMessages implements Runnable{
	
	Socket clientSocket;
	PrintWriter out;
	String userInput;
	
	public SendMessages(Socket aSocket)
	{
		clientSocket = aSocket;
		try
		{
			out = new PrintWriter(clientSocket.getOutputStream(), true);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public void sendMessage()
	{	
		out.println(userInput);

	}
	
	public void run()
	{
		while(true)
		{
			sendMessage();
		}
	}
	
	public void setText(String newInput)
	{
		userInput = newInput;
	}
	
}