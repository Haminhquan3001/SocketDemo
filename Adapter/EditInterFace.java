/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Adapter;

import Model.Automobile;
import Model.MyLHM;

public interface EditInterFace {
void createLHM();
MyLHM getLHM();
Automobile getAuto();
void updateOptionName(String optionSetName, String optionName, String newName);
}
