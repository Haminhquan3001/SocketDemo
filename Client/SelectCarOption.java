/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Client;

import java.util.*;

import Model.Automobile;

public class SelectCarOption {
private Scanner in = new Scanner(System.in);

public SelectCarOption() {
	
}
public void configureAuto(Object Autoobj) {
	boolean check = isAuto(Autoobj);
	if(check) {
		System.out.println("Configuring Auto....");
	}else {
		System.out.println("The oject passed in is not an Auto. Please try again!");
	}
}

public boolean isAuto(Object temp) {
	boolean isAutomobile = false;

	try {
		Automobile a1 = new Automobile();
		a1 = (Automobile) temp;
		isAutomobile = true;
	}
	catch (ClassCastException e) {
		System.out.println("");
		isAutomobile = false;
	}

	return isAutomobile;
}
}
