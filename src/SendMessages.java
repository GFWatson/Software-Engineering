import java.net.*;
import java.io.*;

public class SendMessages implements Runnable{
	
	Socket clientSocket;
	PrintWriter out;
	public String userInput ="1";
	
	
	public SendMessages(Socket aSocket)
	{
		clientSocket = aSocket;
		try
		{
			System.out.println("userInput = " + userInput);
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

		sendMessage();

	}
	
	public void setText(String newInput)
	{
		userInput = newInput;
		run();
		
	}
	
}