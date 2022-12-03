/*	Quan Minh Ha - CIS 35B - Lab4
 * Date Submitted: 5/25/2021
 * 
 * */
package Driver;
import Adapter.BuildAuto;
import Adapter.EditInterFace;
import Scale.EditOptions;

public class Driver4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditOptions edit1 = new EditOptions(1, "Color", "Blu", "Blue");
		EditOptions edit2 = new EditOptions(2, "Color", "Blu", "Red");
		EditInterFace temp = new BuildAuto();
		EditOptions edit3 = new EditOptions(3, "Color", "Blu", "Blue");
		EditOptions edit4 = new EditOptions(4, "Color", "Blu", "Red");
		
		System.out.println("Printing edit1 before testing\n");
		edit1.printAutomobile();
	
		System.out.println("\n\n");
			
		Thread t1 = new Thread(edit1);
		Thread t2 = new Thread(edit2);
		Thread t3 = new Thread(edit3);
		Thread t4 = new Thread(edit4);
		
		try {
		//sync: Should print Thread 1 or 2 with Synchronized done!
		t1.start();
		t2.start();
		
		//non syn: Should print Thread 3 or 4 with non-Synchronized done!
		t3.start();
		t4.start();
		} catch (Exception e) {
			System.out.println("Thread Interrupted");
		}
		
		//when all thread are executed, the Color should be changed from Blue --> Blu
}

}

/*	SAMPLE RUN
 * 
You have successfully add: Focus Wagon ZTW to the LinkedHashMap
You have successfully add: Focus Wagon ZTW to the LinkedHashMap
You have successfully add: Focus Wagon ZTW to the LinkedHashMap
You have successfully add: Focus Wagon ZTW to the LinkedHashMap
Printing edit1 before testing

Automobile Name: Focus Wagon ZTW
Model:Model S
Make:Ford
Key:Focus Wagon ZTWFordModel S
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



Running Threads....
Running Threads....
Starting Thread 3:
Blu ---> Blue
Running Threads....
Founded!
Starting Thread 1:
Blu ---> Blue
Running Threads....
Starting Thread 4:
Blu ---> Red
Founded!
Thread 1 with Synchronized done!
NOT Found!
Thread 3 with non-Synchronized done!
Thread 4 with non-Synchronized done!
Starting Thread 2:
Blu ---> Red
NOT Found!
Thread 2 with Synchronized done!
 * 
 * 
 * */
