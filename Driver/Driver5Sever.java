/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Driver;

import Adapter.BuildAuto;
import Client.DefaultSocketClient;
import Server.AutoSever;
import Server.DefaultSocketServer;

public class Driver5Sever {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		AutoSever autosever = new BuildAuto();
		autosever.serve(1459);
		
		DefaultSocketClient socketClient = new DefaultSocketClient("127.0.0.2", 1459);
		socketClient.run();
	}

}

/*		TESTING FOR Option 0
 * Connecting to host...

Connected to host, creating object streams ... 
/127.0.0.2
Creating server object streams ... 
Object streams has been created
Sending client interaction choices ... 
Reading client request...
Communicating with host ... 
Received server response ... 
Sever:
Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection

Response to server: 
0
Sending 0 to server ... 

Closing client input stream ... 
The request is 0
Closing server input stream for client /127.0.0.1 ... 
Closing server output stream for client /127.0.0.1 ... 
Closing client socket /127.0.0.1 ... 
Closing client output Stream

Closing client console input stream

Closing Client socket
 * 
 * */

/* TESTING FOR Option 1
 * Connecting to host...

Connected to host, creating object streams ... 
/127.0.0.2
Creating server object streams ... 
Object streams has been created
Sending client interaction choices ... 
Reading client request...
Communicating with host ... 
Received server response ... 
Sever:
Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection


Response to server: 
1
Sending 1 to server ... 

The request is 1
Waiting for client to upload file ... 
Received server response ... 
Sever:
Upload a file to create an Automobile

Response to server: 
Properties.txt
Sending {Option4=Power, Option3=Side Impacts, Option2=Brakes, Option1=Transmission, OptionValue1bPrice=815, OptionValue2cPrice=1625, OptionValue3aPrice=0, CarMake=Toyota, OptionValue2a=Standard, OptionValue3b=Selcted, CarModel=Prius, OptionValue3a=None, OptionValue4b=Selected, OptionValue4bPrice=595, OptionValue4a=None, OptionValue2aPrice=400, OptionValue1b=Standard, OptionValue2c=ABSAT, OptionValue3bPrice=350, OptionValue1a=Auto, OptionValue2b=ABS, OptionValue4aPrice=0, OptionValue1aPrice=0} to server ... 

{Option4=Power, Option3=Side Impacts, Option2=Brakes, Option1=Transmission, OptionValue1bPrice=815, OptionValue2cPrice=1625, OptionValue3aPrice=0, OptionValue3b=Selcted, OptionValue2a=Standard, CarMake=Toyota, OptionValue4bPrice=595, OptionValue4b=Selected, OptionValue3a=None, CarModel=Prius, OptionValue4a=None, OptionValue2aPrice=400, OptionValue3bPrice=350, OptionValue2c=ABSAT, OptionValue1b=Standard, OptionValue2b=ABS, OptionValue1a=Auto, OptionValue4aPrice=0, OptionValue1aPrice=0}
Adding new Automobile to database ... 
Building Auto 
You have successfully add:  to the LinkedHashMap
Received server response ... 
Sever:Automobile Object has sucessfully been created
 * 
 * 
 * 
 * */

/*	TESTING FOR Option 2
 * 
Connecting to host...

Connected to host, creating object streams ... 
/127.0.0.2
Creating server object streams ... 
Object streams has been created
Sending client interaction choices ... 
Reading client request...
Communicating with host ... 
Received server response ... 
Sever:
Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection


Response to server: 
2
Sending 2 to server ... 

The request is 2
Waiting for client to select Automobile ... 
Received server response ... 
Sever:Select an Automobile from the following list to configure: 
Toyota
Ford
Telsa

Response to server: 
2
Sending 2 to server ... 

Sending Automobile object to client ... 
Received server response ... 
Sever:Your automobile have just been set to Telsa

 * 
 * */
 