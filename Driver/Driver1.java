/*	Quan Minh Ha - CIS 35B - Lab4
 * Date Submitted: 5/25/2021
 * 
 * */
package Driver;

import Adapter.BuildAuto;
import Adapter.CreateAuto;
import Adapter.UpdateAuto;

//The driver test the API 
public class Driver1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto("Automobiles.txt");
		a1.printAutomobile(); // Testing CreateAuto Interface

		System.out.println("\n");

		UpdateAuto a2 = new BuildAuto(); // Testing UpdateAuto Interface
		a2.updateOptionSetName("Focus Wagon ZTW", "Power", "Power Option");
		System.out.println();
		a2.updateOptionPrice("Focus Wagon ZTW", "Color", "Blue", .50);
	}

}

/*
 * SAMPLE RUN 
 Automobile Name: Focus Wagon ZTW
Base Price: 18445.0
OptionSet Name: Color
Option Name: Blue 
Price: 0.0
Option Name: Red 
Price: 0.0
Option Name: Green 
Price: 0.0
Option Name: Black 
Price: 0.0
OptionSet Name: Transmission
Option Name: Auto 
Price: 0.0
Option Name: Standard 
Price: 815.0
OptionSet Name: Brakes
Option Name: Standard 
Price: 0.0
Option Name: ABS 
Price: 400.0
Option Name: ABSAT 
Price: 1625.0
OptionSet Name: Side Impacts
Option Name: None 
Price: 0.0
Option Name: Selected 
Price: 350.0
OptionSet Name: Power
Option Name: None 
Price: 0.0
Option Name: Selected 
Price: 595.0

Serialized data is saved in Auto.txt

Successfully deserialized data from Auto.txt

Automobile Name: Focus Wagon ZTW
Base Price: 18445.0
OptionSet Name: Color
Option Name: Blue 
Price: 0.0
Option Name: Red 
Price: 0.0
Option Name: Green 
Price: 0.0
Option Name: Black 
Price: 0.0
OptionSet Name: Transmission
Option Name: Auto 
Price: 0.0
Option Name: Standard 
Price: 815.0
OptionSet Name: Brakes
Option Name: Standard 
Price: 0.0
Option Name: ABS 
Price: 400.0
Option Name: ABSAT 
Price: 1625.0
OptionSet Name: Side Impacts
Option Name: None 
Price: 0.0
Option Name: Selected 
Price: 350.0
OptionSet Name: Power
Option Name: None 
Price: 0.0
Option Name: Selected 
Price: 595.0

 */
