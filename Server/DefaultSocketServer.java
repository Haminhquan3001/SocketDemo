/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Server;

import java.io.*;
import java.net.*;

public class DefaultSocketServer extends Thread {

	private int port;
	private ServerSocket server;

	public DefaultSocketServer(int port) {
		this.port = port;
		server = null;
		try {
			this.server = new ServerSocket(port);
			
		} catch (IOException e) {
			System.err.println("Could not listen on port " + port + " ... ");
			System.exit(1);
		}
	}
	
	@Override
	public void run() {
		Socket client = null;
		while (true) {
			try {
				client = server.accept();
			} catch (IOException e) {
				System.err.println("Error establishing client connection ... ");
				System.exit(1);
			}
			System.out.println(client.getLocalAddress());
			new DefaultClientSocket(client).run();
			
		}
		
	}

}
