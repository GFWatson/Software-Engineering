import java.net.*;
import java.io.*;

public class SendMessages implements Runnable{
	
	Socket clientSocket;
	PrintWriter out;
	public String userInput ="1";
	
	//constructor
	//creates print writer that will send messages from the server
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
	//prints messages to server
	public void sendMessage()
	{	
		out.println(userInput);
	}
	//run method for thread
	public void run()
	{

		sendMessage();

	}
	//set message to send to server
	public void setText(String newInput)
	{
		userInput = newInput;
		run();
		
	}
	
}