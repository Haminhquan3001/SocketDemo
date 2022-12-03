/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */

package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Adapter.CreateAuto;
import Adapter.UpdateAuto;
import Model.Automobile.OptionSet.Option;

public class Automobile implements Serializable {
	private String AutomobileName;
	private String make;
	private String model;
	private ArrayList<OptionSet> optSet;
	private ArrayList<Option> choice;
	private double baseprice;
	
	public Automobile() {
		AutomobileName = "";
		baseprice = 0.00;
	}
	public String getAllModel() {
		String[] mod = {"Toyota", "Ford", "Telsa"};
		return mod[0]+ "\n" + mod[1] + "\n" + mod[2];
	}
	public Automobile(int size, double baseprice) {
		optSet = new ArrayList<OptionSet>(size);
		for (int i = 0; i < optSet.size(); i++) {
			OptionSet addset = new OptionSet();
			optSet.add(addset);
		}
		this.baseprice = baseprice;
	}

	public Automobile(String AutomobileName, int size, double baseprice) {
		this.AutomobileName = AutomobileName;
		optSet = new ArrayList<OptionSet>(size);
		for (int i = 0; i < optSet.size(); i++) {
			OptionSet addset = new OptionSet();
			optSet.add(addset);
		}
		this.baseprice = baseprice;
	}
	public void setMake(String n) {
		this.make = n;
	}
	public String getMake() {
		return make;
	}
	public void setModel(String n) {
		this.model = n;
	}
	public String getModel() {
		return model;
	}
	public void setAutomobileName(String n) {
		this.AutomobileName = n;
	}

	public void setBasePrice(double bp) {
		this.baseprice = bp;
	}

	public void setOptionset(int i, String n, int size) {
		OptionSet temp = new OptionSet(n, 5);
		optSet.add(i, temp);
	}

	public void setOptionsetatIndex(OptionSet o, int i) {
		optSet.add(i, o);
	}

	public void buildOptionset(int i, double p, String optionName, int x) {
		optSet.get(i).setOpt(optionName, p, x);
	}

	public String getAutomobileName() {
		return AutomobileName;
	}

	public double getBaseprice() {
		return baseprice;
	}

	public ArrayList getOptionSet() {
		return optSet;
	}

	public OptionSet getOptionsetatIndex(int i) {
		return optSet.get(i);
	}
	
	public void setOptionChoice(String setname, String optionname) {
		int k = 0;
		for(int i = 0; i < optSet.size(); i++) {
		
		if(setname.equals(optSet.get(i).getName())) {
			k++;
			optSet.get(i).setOptionChoice(optionname, k);
			
			//optSet.get(i).updateOptionPrice(optSet.get(i).getOptionChoicePrice(), i);
			break;
		} 
		}
	}
	
	public String getOptionChoice(String optionSetname) {
		
		for(int i = 0; i < optSet.size(); i++) {
			if(optionSetname.equals(optSet.get(i).getOptionChoiceName())|| optionSetname.equals(optSet.get(i).getName())) {
				return optSet.get(i).getOptionChoice().getOptionname();
			}
	}
		return null;
		}
	
	public String getKey() {
		return getAutomobileName()+getMake()+getModel();
	}
	
	public double getOptionChoicePrice(String optionSetname) {
		int i;
		int pos = 0;
		for(int k = 0; k < optSet.size();k++) {
			if(optionSetname.equals(optSet.get(k).getOptionChoiceName())) {
				pos = k;
				break;
			}
		}
		System.out.println("You have bought " + optSet.get(pos).getOptionChoiceName() +" with $:" + optSet.get(pos).getOptionChoicePrice());
		optSet.get(pos).updateOptionPrice(-optSet.get(pos).getOptionChoice().getPrice(), pos);
		return optSet.get(pos).getOptionChoicePrice();
		}
	public double getOptionChoicePricewithNoSubtract(String optionname) {
		int pos = 0;
		for(int k = 0; k < optSet.size();k++) {
			if(optionname.equals(optSet.get(k).getOptionChoiceName())) {
				pos = k;
				break;
			}
		}
		System.out.println("You have bought " + optSet.get(pos).getOptionChoiceName() +" with $:" + optSet.get(pos).getOptionChoicePrice());
		return optSet.get(pos).getOptionChoicePrice();
	}
		

	public boolean findOptionSetbyName(String n) {
		int i;
		for (i = 0; i < optSet.size(); i++) {
			if (n.equals(optSet.get(i).getName())) {
				System.out.printf("OptionSet Found!");
				return true;
			}
		}
		return false;
	}
	public double getTotalPrice() {
		double sum = 0;
		for(int i =0; i < optSet.size(); i++) {
			String a = optSet.get(i).getOptionChoiceName();
			String b = getOptionChoice(optSet.get(i).getName());
			if(optSet.get(i).getOptionChoiceName().equals(getOptionChoice(optSet.get(i).getName())) && a != "" && b != "") {
			sum+= optSet.get(i).getTotalPrice();
			}
		}
		return sum;
	}
	public void deleteOptionSetbyIndex(int i) {
		optSet.get(i).deleteOptionSetatIndex(i);
	}

	public void deleteOptionSetbyName(String n) {
		for (int i = 0; i < optSet.size(); i++) {
			if (n.equals(optSet.get(i).getName())) {
				optSet.get(i).setName("");
				optSet.get(i).setOpt("", 0, 0);
				System.out.println("Delete successfully");
			} else {
				System.out.printf("Unable to delete the option set || Check the name of the OptionSet again");
			}
		}
	}

	public void updateOptionSetName(String Modelname, String OptionSetname, String newname) {
		for (int i = 0; i < optSet.size(); i++) {
			if (getAutomobileName().equals(Modelname)) {
				if (optSet.get(i).getName().equals(OptionSetname)) {
					optSet.get(i).setName(newname);
					System.out.println("Updating the OptionSetName......\n");
					System.out.println(Modelname + "\nOptionSet name: " + optSet.get(i).getName());
				}
			} else {
				System.out.println("Invalid Automobile name!");
			}
		}

	}

	public void updateOptionset(String n, double p, int i) {
		optSet.get(i).updateOption(n, p, i);
	}

	public void updateOptionPrice(String Modelname, String optionanme, String Option, double newprice) {
		for (int i = 0; i < optSet.size(); i++) {
			if (getAutomobileName().equals(Modelname)) {
				if (optSet.get(i).getName().equals(optionanme)) {
					optSet.get(i).updateOptionPrice(newprice, i);
					System.out.println("Updating Option Price.........\n");
					System.out.println(Modelname + "\nOptionSet name: " + optSet.get(i).getName() + "\nNew Price:"
							+ optSet.get(i).getOneopt(i).getPrice());
				}
			} else {
				System.out.println("Invalid Modelname!");
			}
		}
	}
	
	
	public void updateOptionName(String optionSetName, String optionName, String newName) {
		for(int i = 0; i < optSet.size(); i++) {
		if(optionSetName.equals(optSet.get(i).getName())) {
			if (optSet.get(i).getOptionName(i).substring(0,3).equals(newName.substring(0,3))) {
				optSet.get(i).setOptionName(i, optionName);
				System.out.println("Founded!");
			}
			else {
				System.out.println("NOT Found!");
			}
		}
			}
	}
	public void printAutomobile() {
		System.out.println("Automobile Name: " + getAutomobileName());
		System.out.println("Model:" + getModel());
		System.out.println("Make:" + getMake());
		System.out.println("Key:" + getKey());
		System.out.println("Base Price: " + baseprice);
		for (int i = 0; i < optSet.size(); i++) {
			optSet.get(i).printOptionSet();
		}
	}

	protected class OptionSet implements Serializable {
		private ArrayList<Option> opt;
		private String name;
		private Option choice = new Option();

		protected OptionSet() {
			opt = null;
			name = "";
		}

		protected OptionSet(int size) {
			opt = new ArrayList<Option>(size);
			for (int i = 0; i < opt.size(); i++) {
				Option optadd = new Option();
				opt.add(optadd);
			}
		}

		protected OptionSet(String name, int size) {
			this.name = name;
			opt = new ArrayList<Option>(size);
			for (int i = 0; i < opt.size(); i++) {
				Option optadd = new Option();
				opt.add(optadd);
			}
		}
		
		protected void setName(String n) {
			this.name = n;
		}

		protected void setOpt(String name, double price, int i) {
			Option temp = new Option(name, price);
			opt.add(i,temp);
		}

		protected void setOneopt(Option o, int i) {
			opt.add(i, o);
		}

		protected String getName() {
			return name;
		}

		protected ArrayList getOption() {
			return opt;
		}
		protected double getOptionChoicePrice() {
			return choice.getPrice();
		}
		protected Option getOneopt(int i) {
			return opt.get(i);
		}
		protected boolean isExist() {
			return choice ==null;
		}
		protected void findOptionbyName(String n) {

			for (int i = 0; i < optSet.size(); i++) {

				if (n.equals(opt.get(i).getOptionname())) {
					System.out.printf("Option Found!");
				} else {
					System.out.printf("Unable to find the option || Check the name of the Option again");
				}
			}
		}
		protected void setOptionName(int i,String newName) {
			opt.get(i).setOptionname(newName);
		}
		protected String getOptionName(int i) {
			return opt.get(i).getOptionname();
		}
		
		protected void setOptionChoice(String optionName, int i) {
			choice.setOptionname(optionName);
			choice.setPrice(opt.get(i).getPrice());
			
			for(int j = 0; j < opt.size(); j++) {
				if(optionName.equals(opt.get(j).getOptionname())) {
					System.out.print(opt.get(j).getOptionname() + " " + opt.get(j).getPrice());
					choice.setPrice(opt.get(j).getPrice());
				}
			opt.set(i, choice);
			}
			
		}
		protected Option getOptionChoice() {
				return choice;
		}
		protected String getOptionChoiceName() {
			return choice.getOptionname();
		}
		protected void deleteOptionSetatIndex(int i) {
			name = "";
			opt.add(i, null);
		}

		protected void deleteOptionbyName(String n) {
			for (int i = 0; i < optSet.size(); i++) {
				if (n.equals(opt.get(i).getOptionname())) {
					opt = null;
				} else {
					System.out.printf("Unable to delete the option || Check the name of the Option again");
				}
			}
		}
		protected double getTotalPrice() {
			double total = 0;
			for(int i =0; i < opt.size(); i++) {
				total += opt.get(i).getPrice();
			}
			return -total;
		}
		protected void updateOption(String n, double p, int i) {
			opt.get(i).setOptionname(n);
			opt.get(i).setPrice(p);
		}

		protected void updateOptionPrice(double p, int i) {
			opt.get(i).setPrice(p);
		}

		protected void printOneOptionset(int x) {
			System.out.println("OptionSet Name: " + name);
			
			for (int i = 0; i < opt.size(); i++) {
				System.out.println("Optionname: " + opt.get(i).getOptionname());
				System.out.println("Price: " + opt.get(i).getPrice());
			}
		}

		protected void printOptionSet() {
			System.out.println("OptionSet Name: " + name);
			for (int j = 0; j < opt.size(); j++) {
				opt.get(j).printOption();
			}
		}

		class Option implements Serializable {
			private String Optioname;
			private double price;

			protected Option() {
				Optioname = "";
				price = 0.00;
			}

			protected Option(String Optioname, double price) {
				this.Optioname = Optioname;
				this.price = price;
			}

			protected void setOptionname(String n) {
				this.Optioname = n;
			}

			protected void setPrice(double p) {
				this.price = p;
			}

			protected String getOptionname() {
				return Optioname;
			}

			protected double getPrice() {
				return price;
			}

			protected void printOption() {
				System.out.println("Option Name: " + getOptionname() + "\nPrice: " + getPrice());
			}

		}
	}
}
