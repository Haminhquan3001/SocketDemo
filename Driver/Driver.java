/*	Quan Minh Ha - CIS 35B - Lab4
 * Date Submitted: 5/25/2021
 * 
 * */

package Driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import Model.Automobile;
import Util.FileIO;

public class Driver {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Automobile a = new Automobile();
		FileIO fileIO = new FileIO();
		a = fileIO.readFile("Automobiles.txt");

		a.printAutomobile();
		System.out.println();
		fileIO.SerializeAuto(a);
		System.out.println();
		fileIO.DeserializeAuto(a);
		System.out.println();
		a.printAutomobile();

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

 * */
 