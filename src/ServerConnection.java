import java.io.*;
import java.net.*;

public class ServerConnection
{

	public static void main(String[] args)
		{
	
		try{
		
			Socket clientSocket = new Socket("192.168.0.48", 5000);
			
			Thread t1 = new Thread(new ReceiveMessages(clientSocket));
			Thread t2 = new Thread(new SendMessages(clientSocket));
			Thread t3 = new Thread(new Interface());

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