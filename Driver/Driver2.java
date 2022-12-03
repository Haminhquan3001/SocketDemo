/*	Quan Minh Ha - CIS 35B - Lab4
 * Date Submitted: 5/25/2021
 * 
 * */

package Driver;

import java.io.IOException;

import Exception.AutoException;
import Model.Automobile;
import Util.FileIO;

public class Driver2 {

	public static void main(String[] args) throws IOException, AutoException {
		// TODO Auto-generated method stub
		// This driver test the exception handling
		FileIO f1 = new FileIO();
		f1.TestException("AutoError.txt");
	}

}

/*
 * SAMPLE RUN
 * 
AutoException: Errornum[100]	Errormsg: Missing the name of the Model

You are missing the name of your model. We will add a temporary name: Ferrari
Fixing...
A temporary name have just been added to your model

AutoException: Errornum[101]	Errormsg: Unknown price
AutoException: Errornum[102]	Errormsg: Unknown numbers of Option
AutoException: Errornum[103]	Errormsg: Unknown name of the OptionSet
AutoException: Errornum[104]	Errormsg: Unknown numbers of the Option

Automobile Name: Ferrari
Base Price: 0.0

 * */
