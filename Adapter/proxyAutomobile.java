/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import Model.Automobile;
import Model.MyLHM;
import Server.DefaultSocketServer;

public abstract class proxyAutomobile {
	private static Automobile auto;
	private static MyLHM<Automobile> lhm;
	// 2 methods for UpdateAuto interface
	public void updateOptionSetName(String modelname, String optionSetname, String newName) {
		// TODO Auto-generated method stub
		auto.updateOptionSetName(modelname, optionSetname, newName);
	}

	public void updateOptionPrice(String modelname, String Optionname, String Option, double newprice) {
		// TODO Auto-generated method stub
		auto.updateOptionPrice(modelname, Optionname, Option, newprice);
	}

	// 2 methods for CreateAuto interface
	public void printAutomobile() {
		// TODO Auto-generated method stub
		auto.printAutomobile();
	}

	public void buildAuto(String filename) {
		// TODO Auto-generated method stub
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			int count, num;
			String Carname;
			String make, model;
			String name;
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
					auto = new Automobile(Carname, count, price);
					auto.setMake(make);
					auto.setModel(model);
					for (int i = 0; i < count; i++) { // i is index of OptionSet[i]
						name = buff.readLine(); // OptionSet name
						num = Integer.parseInt(buff.readLine());// size of Options
						auto.setOptionset(i, name, num);
						for (j = 0; j < num; j++) {
							line = buff.readLine();

							StringTokenizer st = new StringTokenizer(line);
							while (st.hasMoreTokens()) {
								optionName = st.nextToken();
								optionName = optionName.replace(',', ' ');
								value = Integer.parseInt(st.nextToken());
							}
							auto.buildOptionset(i, value, optionName, j);
						}
					}
					line = buff.readLine();
				}
			}
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void createLHM() {
		lhm = new MyLHM<>();
		lhm.add(auto.getKey(), auto);
	}
	public MyLHM getLHM() {
		return lhm;
	}
	public Automobile getAuto() {
		return auto;
	}
	
	 public void updateOptionName(String optionSetName, String optionName, String newName) {
		 auto.updateOptionName(optionSetName, optionName, newName);
	 }
	 
	 public Automobile readProperties(String filename) {
			String carMake, carModel, Option, optName, optPrice;
			Properties prop = new Properties();
			FileInputStream in;
			auto = new Automobile();
			try {
				in = new FileInputStream(filename);
				prop.load(in);
				
				carMake = prop.getProperty("CarMake");
				auto.setMake(carMake);
				if(!carMake.equals(null)) {
					
					carModel = prop.getProperty("CarModel");
					auto.setModel(carModel);
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
			return auto;
				}
	 
			public void setProperties(Object properties) {
				auto = new Automobile();
				Properties prop = new Properties();
				auto.setMake(((Properties) properties).getProperty("CarMake"));
				auto.setModel(((Properties) properties).getProperty("CarModel"));
					auto.setOptionset(0, ((Properties) properties).getProperty("Option1"), 2);
					
					auto.buildOptionset(0, Double.parseDouble(((Properties) properties).getProperty("OptionValue1aPrice")),
								((Properties) properties).getProperty("OptionValue1a"), 0);
					auto.buildOptionset(0, Double.parseDouble(((Properties) properties).getProperty("OptionValue1bPrice")),
							((Properties) properties).getProperty("OptionValue1b"), 1);

					auto.setOptionset(1, ((Properties) properties).getProperty("Option2"), 2);
					
					auto.buildOptionset(1, Double.parseDouble(((Properties) properties).getProperty("OptionValue2aPrice")),
								((Properties) properties).getProperty("OptionValue2a"), 0);
					auto.buildOptionset(1, Double.parseDouble(((Properties) properties).getProperty("OptionValue2bPrice")),
							((Properties) properties).getProperty("OptionValue2b"), 1);
					auto.buildOptionset(1, Double.parseDouble(((Properties) properties).getProperty("OptionValue2cPrice")),
							((Properties) properties).getProperty("OptionValue2c"), 2);
					
					auto.setOptionset(2, ((Properties) properties).getProperty("Option3"), 2);
					
					auto.buildOptionset(2, Double.parseDouble(((Properties) properties).getProperty("OptionValue3aPrice")),
								((Properties) properties).getProperty("OptionValue3a"), 0);
					auto.buildOptionset(2, Double.parseDouble(((Properties) properties).getProperty("OptionValue3bPrice")),
							((Properties) properties).getProperty("OptionValue3b"), 1);
					
					auto.setOptionset(3, ((Properties) properties).getProperty("Option4"), 2);
					
					auto.buildOptionset(3, Double.parseDouble(((Properties) properties).getProperty("OptionValue4aPrice")),
								((Properties) properties).getProperty("OptionValue4a"), 0);
					auto.buildOptionset(3, Double.parseDouble(((Properties) properties).getProperty("OptionValue4bPrice")),
							((Properties) properties).getProperty("OptionValue4b"), 1);

				}

			public void serve(int port) {
				DefaultSocketServer df = new DefaultSocketServer(port);
				df.start();
			}
}
