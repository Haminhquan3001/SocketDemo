/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Adapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Model.Automobile;

public abstract class CarConfig {
	private static Automobile at;
	
		public void setOptionChoice(String oldname, String newname) {
		at.setOptionChoice(oldname, newname);
	}

	
	public String getOptionChoice(String optionSetname) {
		// TODO Auto-generated method stub
	return at.getOptionChoice(optionSetname);
	}

	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return at.getTotalPrice();
	}
	public double getOptionChoicePrice(String optionSetname) {
		return at.getOptionChoicePrice(optionSetname);
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
					at = new Automobile(Carname, count, price);
					at.setMake(make);
					at.setModel(model);
					for (int i = 0; i < count; i++) { // i is index of OptionSet[i]
						name = buff.readLine(); // OptionSet name
						num = Integer.parseInt(buff.readLine());// size of Options
						at.setOptionset(i, name, num);
						for (j = 0; j < num; j++) {
							line = buff.readLine();

							StringTokenizer st = new StringTokenizer(line);
							while (st.hasMoreTokens()) {
								optionName = st.nextToken();
								optionName = optionName.replace(',', ' ');
								value = Integer.parseInt(st.nextToken());
							}
							at.buildOptionset(i, value, optionName, j);
						}
					}
			
				}
				
			}
			
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
