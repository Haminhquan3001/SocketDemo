/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Scale;
import Adapter.BuildAuto;
import Adapter.proxyAutomobile;
import Model.Automobile;
import Model.MyLHM;

public class EditOptions extends proxyAutomobile implements Runnable {
private int threadno;
private int x;
private BuildAuto ba;
private MyLHM<Automobile> lhm;
private String optName;
private String optSetName;
private String newName;


public EditOptions(int x, String OptionSetName, String OptionName, String newName) {
	this.x = x;
	this.threadno = x;
	
	//Extracting the Automobile object from lhm
	ba = new BuildAuto();
	ba.buildAuto("Automobiles.txt");
	ba.createLHM();
	lhm = ba.getLHM();
	this.optName = OptionName;
	this.optSetName = OptionSetName;
	this.newName = newName;
	
}

@Override
public void run() {
	// TODO Auto-generated method stub
	System.out.println("Running Threads....");
	switch(x) {
	case 3: System.out.println("Starting Thread " + threadno + ":" );
	try {
	System.out.println(optName + " ---> " +newName);
	lhm.get(ba.getAuto()).updateOptionName(optSetName, optName, newName);
	Thread.sleep(3000);
	System.out.println("Thread "+ x +" with non-Synchronized done!");
	break;
	} 
	catch(Exception e) {
		System.out.println("\nThread Interuppted");
	}
	
	case 4: System.out.println("Starting Thread " + threadno + ":" );
	try {
	System.out.println(optName + " ---> " +newName);
	lhm.get(ba.getAuto()).updateOptionName(optSetName, optName, newName);
	//ba.getAuto().printAutomobile();
	Thread.sleep(3000);
	System.out.println("Thread "+ x +" with non-Synchronized done!");
	break;
	} 
	catch(Exception e) {
		System.out.println("\nThread Interuppted");
	}
	}
	runwithSync();
}

public synchronized void runwithSync() {
	synchronized(ba.getAuto()) {
	switch(x) {
	case 1: System.out.println("Starting Thread " + threadno + ":" );
	try {
	System.out.println(optName + " ---> " +newName);
	lhm.get(ba.getAuto()).updateOptionName(optSetName, optName, newName);
	System.out.println("Thread "+ x +" with Synchronized done!");
	Thread.sleep(3000);
	notifyAll();
	} 
	catch(Exception e) {
		System.out.println("\nThread Interuppted");
	}
	break;
	case 2: System.out.println("Starting Thread " + threadno + ":" );
	try {
	System.out.println(optName + " ---> " +newName);
	lhm.get(ba.getAuto()).updateOptionName(optSetName, optName, newName);
	System.out.println("Thread "+ x +" with Synchronized done!");
	Thread.sleep(3000);
	notifyAll();
	} 
	catch(Exception e) {
		System.out.println("\nThread Interuppted");
	}
	break;
	}
	notifyAll();
	}
	
}
}
