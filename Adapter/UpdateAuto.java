/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Adapter;

public interface UpdateAuto {
	void updateOptionSetName(String modelname, String optionSetname, String newName);

	void updateOptionPrice(String modelname, String Optionname, String Option, double newprice);
}
