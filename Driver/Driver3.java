/*	Quan Minh Ha - CIS 35B - Lab4
 * Date Submitted: 5/25/2021
 * 
 * */
package Driver;

import java.io.IOException;

import Adapter.BuildCarConfig;
import Adapter.CalculatePrice;
import Adapter.CarConfig;
import Adapter.MakingChoices;
import Model.Automobile;
import Model.MyLHM;
import Util.FileIO;

public class Driver3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Testing CarConfig
		final String filename = "Automobiles.txt";
		MakingChoices am = new BuildCarConfig();
		am.buildAuto(filename);
		am.setOptionChoice("Transmission", "Standard");
		System.out.println();
		
		System.out.println("It should print out Standard: " + am.getOptionChoice("Transmission"));
		am.setOptionChoice("Color", "Blue");
		System.out.println(am.getOptionChoice("Color"));
		am.setOptionChoice("Brakes", "ABS");
		System.out.println(am.getOptionChoice("Brakes"));
	
		
		CalculatePrice c1 = new BuildCarConfig();
		System.out.println();
		System.out.println(c1.getOptionChoicePrice("Transmission"));
		System.out.println(c1.getOptionChoicePrice("Brakes"));
		System.out.println("The total price is: " + c1.getTotalPrice());
		System.out.println();
		
		//Testing LinkedHashMap
		Automobile a = new Automobile();
		FileIO f1 = new FileIO();
		a = f1.readFile(filename);
		//a.printAutomobile();
		MyLHM lhm = new MyLHM();
		lhm.add(a.getAutomobileName()+a.getMake()+a.getModel(), a);
		System.out.println();
	
		System.out.println("Should print true: " + lhm.find(a, a.getKey()));
		
		System.out.println("The key is :" + a.getKey());
		System.out.println();
		lhm.remove(a, a.getKey());
		System.out.println();
		System.out.println("Should print false: " + lhm.find(a, a.getKey()));
		
		lhm.add(a.getAutomobileName()+a.getMake()+a.getModel(), a);
		System.out.println();
		lhm.delete();
		System.out.println("Should print false: " + lhm.find(a, a.getKey()));
	}

}
