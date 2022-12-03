/*	Quan Minh Ha - CIS 35B - Lab5
 * Date Submitted: 6/4/2021
 * 
 * */
package Exception;

import Model.Automobile;

public class AutoException extends Exception {
	private int errornum;
	private String errormsg;
	private Fix1to100 f1;
	
	public AutoException() {
		super();

	}

	public AutoException(String errormsg) {
		this.errormsg = errormsg;
	}

	public AutoException(int errornum) {
		this.errornum = errornum;
	}

	public AutoException(int errornum, String msg) {
		this.errornum = errornum;
		this.errormsg = msg;
	}

	public void SetErrorNum(int errornum) {
		this.errornum = errornum;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public int getErrornum() {
		return errornum;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void printException() {
		System.out.println("AutoException: Errornum[" + getErrornum() + "]\tErrormsg: " + getErrormsg());
	}

	public Fix1to100 getFix1to100() {
		return f1;
	}

	public void fixExcpetion(int errornum) {
		f1 = new Fix1to100();
		switch (errornum) {
		case 100:
			f1.fix(errornum);
			break;
		case 99:
			f1.fix(errornum);
			break;
		case 98:
			f1.fix(errornum);
			break;

		}

	}

	public class Fix1to100 {
		private String msg;

		public Fix1to100() {
			msg = "";
		}

		public void fix(int errornum) {
			if (errornum == 100) {
				msg = "Ferrari";
				System.out.println("\nYou are missing the name of your model. We will add a temporary name: " + msg);
				System.out.println("Fixing...");
				System.out.println("A temporary name have just been added to your model");
				System.out.println();
			}

		}

		public String getMsg() {
			return msg;
		}
	}
}
