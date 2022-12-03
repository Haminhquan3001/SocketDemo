/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Client;

import java.io.*;
import java.net.*;


public class DefaultSocketClient extends Thread {
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private BufferedReader stdIn;
	private Socket sock;
	private int port;
	private String host;
	private CarModelOptionsIO clientFTP;
	private SelectCarOption clientProtocol;
	
	public DefaultSocketClient(String host,int port) {
		this.host = host;
		this.port = port;
	}
	
	public void createConnection() {
		try {
			System.out.println("Connecting to host...");
			
			this.sock = new Socket(host, port);
			System.out.println("\nConnected to host, creating object streams ... ");
			
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			clientFTP = new CarModelOptionsIO();
			clientProtocol = new SelectCarOption();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error connecting I/O for connection and host ...");
			System.exit(1);
		}
	}
	
	public void handleConnection() {
		Object fromServer, toServer = null;
		try {
			System.out.println("Communicating with host ... ");
			
			while((fromServer = in.readObject()) != null) {
				System.out.println("Received server response ... ");
				System.out.println("Sever:" + fromServer.toString());
				
				
				if (clientProtocol.isAuto(fromServer))
					clientProtocol.configureAuto(fromServer);

				System.out.println("Response to server: ");
				toServer = stdIn.readLine();
				
				if (toServer.toString().contains(".txt")) {
					toServer = clientFTP.readPropfile(toServer.toString());
				}
				
				System.out.println("Sending " + toServer + " to server ... ");
				sendOutput(toServer);
				System.out.println();
				
				if(toServer.equals("0")) {
					break;
				}
			}
				System.out.println("Closing client input stream ... ");
				in.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error in downloaded object, object may be corrupted ... ");
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error in I/O stream ... ");
			System.exit(1);
		}
	}
	
	public void sendOutput(Object obj) {
		try {
			out.writeObject(obj);
		}
		catch (IOException e) {
			System.err.println("Error in I/O stream while sending object to host ... ");
			System.exit(1);
		}
	}
	@Override
	public void run() {
		createConnection();
		handleConnection();
		try {
			System.out.println("Closing client output Stream");
			out.close();
			
			System.out.println("\nClosing client console input stream");
			stdIn.close();
			
			System.out.println("\nClosing Client socket");
			sock.close();
		} catch (IOException e) {
			System.err.println("Error ending client connection ... ");
			System.exit(1);
		}
		
		
	}
}
