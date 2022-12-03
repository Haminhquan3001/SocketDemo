/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Server;

import java.io.*;
import java.net.*;

public class DefaultClientSocket extends Thread {
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket clientSocket;
	private BuildCarModelOptions protocol;
	
	public DefaultClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public void handleConnection(Socket sock) {
			System.out.println("Creating server object streams ... ");
		try {
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			System.out.println("Object streams has been created");
			
		}
		catch (IOException e) {
			System.err.println("Error creating server object streams ... ");
			System.exit(1);
		}
		
		protocol = new BuildCarModelOptions();
		String menu = "\nEnter 1 to upload a new Automobile\n"
				+ "Enter 2 to configure an Automobile\n"
				+ "Enter 0 to terminate connection\n";
		
		try {
			do {
			System.out.println("Sending client interaction choices ... ");
			sendOutput(menu);
			System.out.println("Reading client request...");
			int request = Integer.parseInt(in.readObject().toString());
			System.out.println("The request is "  + request);
			if(request == 0) {
				break;
			}
			sendOutput(protocol.setStatus(request));
			
			if (request >= 1 && request <= 2) {
				handleInput(request);
				
			}			
			} while(in.readObject() != null);
			
			
			System.out.println("Closing server input stream for client " + sock.getInetAddress() + " ... ");
			in.close();
			
		} catch (ClassNotFoundException e) {
			System.err.println("Error in uploaded object, object may be corrupted ... ");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error handling client connection ... ");
			System.exit(1);
		}
		
	}
	
	public void handleInput(int request) {
		Object fromClient = null;
		Object toClient = null;

		try {
			switch (request) {
				case 1: //Client request to build Automobile
						System.out.println("Waiting for client to upload file ... ");
						fromClient = in.readObject();
				
						System.out.println(fromClient);
						System.out.println("Adding new Automobile to database ... ");
					
					toClient = protocol.requestAndProcess(fromClient);
					sendOutput(toClient);
					break;

				case 2: //Client request to configure Automobile
				
						System.out.println("Waiting for client to select Automobile ... ");
					fromClient = Integer.parseInt(in.readObject().toString());
				
						System.out.println("Sending Automobile object to client ... ");
					toClient = protocol.requestAndProcess(fromClient);
					sendOutput(toClient);
					break;
					
				default: //Invalid requests
					;
			}
		}
		catch (ClassNotFoundException e) {
			System.err.println("Error in uploaded object, file may be corrupted ... ");
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println("Error in retrieving object from client ... ");
			System.exit(1);
		}
	}
	public void sendOutput(Object obj) {
		try {
			out.writeObject(obj);
		}
		catch (IOException e) {
			System.err.println("Error returning output to client ... ");
			System.exit(1);
		}
	}
	
	@Override
	public void run() {
		
		handleConnection(clientSocket);
		
			System.out.println("Closing server output stream for client " + clientSocket.getInetAddress() + " ... ");
		try {
			out.close();
		}
		catch (IOException e) {
			System.err.println("Error closing server output stream for client " + clientSocket.getInetAddress() + " ... ");
		}

		//Close client socket
			System.out.println("Closing client socket " + clientSocket.getInetAddress() + " ... ");
		try {
			clientSocket.close();
		}
		catch (IOException e) {
			System.err.println("Error closing client socket " + clientSocket.getInetAddress() + " ... ");
		}
	}
}
