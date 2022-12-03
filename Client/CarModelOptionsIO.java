/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Client;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import Model.Automobile;

public class CarModelOptionsIO {
	public CarModelOptionsIO() {

	}

	public Object readPropfile(String filename) {
		Properties propClient = new Properties();
		try {
			propClient.load(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return propClient;
	}
	
	
}
