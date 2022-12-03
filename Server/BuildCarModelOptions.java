/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Server;

import java.util.Properties;

import Adapter.BuildAuto;
import Adapter.proxyAutomobile;
import Model.Automobile;

public class BuildCarModelOptions extends proxyAutomobile {

	private static final int WAITING = 0;
	private static final int REQUEST_BUILD_AUTO = 1;
	private static final int REQUEST_CONFIGURE_AUTO = 2;
	private Automobile AutoObj;
	private AutoSever temp;
	private int status = WAITING;
	
	public BuildCarModelOptions() {
		
	}
	
	public Object requestAndProcess(Object fromClient) {
		Object sucess = "";
		if(status == REQUEST_BUILD_AUTO) {
			System.out.println("Building Auto ");
			temp = new BuildAuto();	
			AutoObj = new Automobile();
			AutoObj = temp.readProperties("Properties.txt");
			
			//temp.setProperties(fromClient);
			temp.createLHM();
			
			sucess = "Automobile Object has sucessfully been created";
		}
		else if(status == REQUEST_CONFIGURE_AUTO) {
			temp = new BuildAuto();	
			AutoObj = new Automobile();
			AutoObj = temp.readProperties("Properties.txt");
			
			if(Integer.parseInt(fromClient.toString()) == 0) {
			AutoObj.setAutomobileName("Toyota");
			}else if(Integer.parseInt(fromClient.toString()) == 1) {
				AutoObj.setAutomobileName("Ford");
			}else {
				AutoObj.setAutomobileName("Telsa");
			}
			sucess = "Your automobile have just been set to " + AutoObj.getAutomobileName();
		}
		this.status = WAITING;
		return sucess;
	}

	public String setStatus(int i) {
		String output = null;
		if (i == 1) {
			this.status = REQUEST_BUILD_AUTO;
			output ="\nUpload a file to create an Automobile";
			
		} else if (i == 2) {
			AutoObj = new Automobile();
			this.status = REQUEST_CONFIGURE_AUTO;
			output = "Select an Automobile from the following list to configure: \n" + AutoObj.getAllModel();
		} else {
			output= "Invalid request";
		}
	
	return output;
	}
}
