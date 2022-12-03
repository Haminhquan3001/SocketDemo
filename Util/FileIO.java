/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */

package Util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamTokenizer;
import java.util.Properties;
import java.util.StringTokenizer;
import Exception.AutoException;
import Model.Automobile;

public class FileIO implements Serializable {
	public FileIO() {

	}

	public Automobile readFile(String filename) throws IOException {
		Automobile am = new Automobile();
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			int count, num;
			String Carname;
			String name;
			String model, make;
			String optionName = "";
			double price;
			double value = 0;
			int j;
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				if (line == null) {
					eof = true;
					break;
				} else {
					Carname = line;
					model = buff.readLine();
					make = buff.readLine();
					price = Double.parseDouble(buff.readLine());
					count = Integer.parseInt(buff.readLine()); // OptionSet length
					am = new Automobile(Carname, count, price);
					am.setMake(make);
					am.setModel(model);
					for (int i = 0; i < count; i++) { // i is index of OptionSet[i]
						name = buff.readLine(); // OptionSet name
						num = Integer.parseInt(buff.readLine());// size of Options
						am.setOptionset(i, name, num);
						for (j = 0; j < num; j++) {
							line = buff.readLine();
							StringTokenizer st = new StringTokenizer(line);
							while (st.hasMoreTokens()) {
								optionName = st.nextToken();
								optionName = optionName.replace(',', ' ');
								value = Integer.parseInt(st.nextToken());
							}
							am.buildOptionset(i, value, optionName, j);
						}
					}
					
				
				}
			}
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return am;
	}

	public void SerializeAuto(Automobile am) {

		try {
			FileOutputStream fOut = new FileOutputStream("Auto.txt");
			ObjectOutputStream out = new ObjectOutputStream(fOut);
			out.writeObject(am);
			out.close();
			fOut.close();
			System.out.println("Serialized data is saved in Auto.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void DeserializeAuto(Automobile am) throws ClassNotFoundException {
		try {
			FileInputStream fIn = new FileInputStream("Auto.txt");
			ObjectInputStream in = new ObjectInputStream(fIn);
			am = (Automobile) in.readObject();
			in.close();
			fIn.close();
			System.out.println("Successfully deserialized data from Auto.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void TestException(String filename) throws AutoException {
		Automobile am = new Automobile();
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			int count = 0, num;
			String Carname = "";
			String name = "";
			double price = 0.00;
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				if (line == null) {
					eof = true;
					break;
				} else {
					// Create an error: missing model name and fix it by adding a temporary name
					try {
						if (line != "123") {
							Carname = line;
							throw new AutoException(100, "Missing the name of the Model");
						} else {
							System.out.println("No error");
						}
					} catch (AutoException e) {
						e.printException();
						e.fixExcpetion(100);
						Carname = e.getFix1to100().getMsg();
					}
					// Creat error: Unknown price
					try {
						price = Double.parseDouble(buff.readLine());
						if (price == 0) {
							throw new AutoException(101, "Unknown price");
						} else {
							System.out.println("No error!");
						}
					} catch (AutoException e) {
						e.printException();
					}
					// Create error: Unknown numbers of Option
					try {
						count = Integer.parseInt(buff.readLine());
						if (count == 0) {
							throw new AutoException(102, "Unknown numbers of Option");
						} else {
							System.out.println("No error!");
						}
					} catch (AutoException e) {
						e.printException();
					}
					// Create error: Unknown name of the OptionSet
					try {
						name = buff.readLine();
						if (name != "123") {
							throw new AutoException(103, "Unknown name of the OptionSet");
						} else {
							System.out.println("No error!");
						}
					} catch (AutoException e) {
						e.printException();
					}
					// Create error: Unknown numbers of the Option
					try {
						num = Integer.parseInt(buff.readLine());
						if (num == 0) {
							throw new AutoException(104, "Unknown numbers of the Option");
						} else {
							System.out.println("No error!");
						}
					} catch (AutoException e) {
						e.printException();
					}
					am = new Automobile(Carname, count, price);
					System.out.println();
					am.printAutomobile();// Testing
					break;
				}
			}
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Properties readProperties(String filename) {
		String carMake, carModel, Option, optName, optPrice;
		Properties prop = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream(filename);
			prop.load(in);
			
			carMake = prop.getProperty("CarMake");
			if(!carMake.equals(null)) {
				carModel = prop.getProperty("CarModel");
				
				Option = prop.getProperty("Option1");
				optName = prop.getProperty("OptionValue1a");
				optPrice = prop.getProperty("OptionValue1aPrice");
				optName = prop.getProperty("OptionValue1b");
				optPrice = prop.getProperty("OptionValue1bPrice");
				
				Option = prop.getProperty("Option2");
				optName = prop.getProperty("OptionValue2a");
				optPrice = prop.getProperty("OptionValue2aPrice");
				optName = prop.getProperty("OptionValue2b");
				optPrice = prop.getProperty("OptionValue2bPrice");
				optName = prop.getProperty("OptionValue2c");
				optPrice = prop.getProperty("OptionValue2cPrice");
				
				Option = prop.getProperty("Option3");
				optName = prop.getProperty("OptionValue3a");
				optPrice = prop.getProperty("OptionValue3aPrice");
				optName = prop.getProperty("OptionValue3b");
				optPrice = prop.getProperty("OptionValue3bPrice");
				
				Option = prop.getProperty("Option4");
				optName = prop.getProperty("OptionValue4a");
				optPrice = prop.getProperty("OptionValue4aPrice");
				optName = prop.getProperty("OptionValue4b");
				optPrice = prop.getProperty("OptionValue4bPrice");
				
			}	
			//System.out.println(prop.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		}
		return prop;
			}

}
