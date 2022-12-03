/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Server;

import java.util.Properties;

import Model.Automobile;

public interface AutoSever {
	void buildAuto(String filename);
	Automobile readProperties(String filename);
	void setProperties(Object fromClient);
	void createLHM();
	Automobile getAuto();
	void serve(int port);
}
