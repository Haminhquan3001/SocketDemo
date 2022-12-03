package Servlet;

import java.io.*;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Adapter.BuildAuto;
import Client.CarModelOptionsIO;
import Model.Automobile;

public class ClientServlet extends HttpServlet {
	/*
	 * This servlet interact with the Client to get the data for the list of
	 * available models
	 * 
	 */
	private String message;
	private Automobile temp;
	public void init() throws ServletException {
		message = "";
	}
	
	
	private Automobile readAuto(String filename) throws IOException {
		ServletContext context = getServletContext();
		InputStream in = context.getResourceAsStream(filename);
		BufferedReader buff = new BufferedReader(new InputStreamReader(in));
		boolean eof = false;
		String Carname, make,model, name, optionName = "";
		double price, value =0;
		int count, num, j;
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
				temp = new Automobile(Carname, count, price);
				temp.setMake(make);
				temp.setModel(model);
				for (int i = 0; i < count; i++) { // i is index of OptionSet[i]
					name = buff.readLine(); // OptionSet name
					num = Integer.parseInt(buff.readLine());// size of Options
					temp.setOptionset(i, name, num);
					for (j = 0; j < num; j++) {
						line = buff.readLine();

						StringTokenizer st = new StringTokenizer(line);
						while (st.hasMoreTokens()) {
							optionName = st.nextToken();
							optionName = optionName.replace(',', ' ');
							value = Integer.parseInt(st.nextToken());
						}
						temp.buildOptionset(i, value, optionName, j);
					}
				}
				line = buff.readLine();
			}
			
		}
		buff.close();
		return temp;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final String filename = "/WEB-INF/Automobiles.txt";
		String carName = request.getParameter("model");
		String Option1 = request.getParameter("Color");
		String Option2 = request.getParameter("Transmission");
		String Option3 = request.getParameter("Brakes");
		String Option4 = request.getParameter("Side Impacts");
		String Option5 = request.getParameter("Power");
		PrintWriter out = response.getWriter();
		temp = new Automobile();
		temp = readAuto(filename);
		
		temp.setModel(carName);
		

		
		out.println("Here is what you selected:");
		out.println(carName + "\t\t" + "\tbaseprice:$" + temp.getBaseprice());
		
		temp.setOptionChoice("Color", Option1);
		out.println("Color: " + Option1 + "\t\tPrice: $" + temp.getOptionChoicePricewithNoSubtract(Option1));
		
		temp.setOptionChoice("Transmission", Option2);
		out.println("Transmission:" + Option2 + "\tPrice: $"+ temp.getOptionChoicePricewithNoSubtract(Option2));
		temp.setOptionChoice("Brakes", Option3);
		if (Option3.length() > 5) {
			out.println("Brakes: " + Option3 + "\tPrice: $"+ temp.getOptionChoicePricewithNoSubtract(Option3));
		} else {
			out.println("Brakes: " + Option3 + "\t\tPrice: $"+ temp.getOptionChoicePricewithNoSubtract(Option3));
		}

		if (Option4 == null) {
			Option4 = "None";
		}
		if (Option5 == null) {
			Option5 = "None";
		}
		
		temp.setOptionChoice("Side Impacts", Option4);
		out.println("Side Impacts: " + Option4 + "\tPrice: $"+temp.getOptionChoicePricewithNoSubtract(Option4));

		temp.setOptionChoice("Power", Option5);
		out.println("Power: " + Option5 + "\t\tPrice: $"+ temp.getOptionChoicePricewithNoSubtract(Option5));
		double total = temp.getBaseprice() + temp.getTotalPrice();
		out.println("\nTotalCost: $" + total);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

/*SAMPLE RUN 
 * 
 * 
 * 
 * 
Here is what you selected:
Tesla			baseprice:$18445.0
Color: Green		Price: $0.0
Transmission:Standard	Price: $815.0
Brakes: ABSAT		Price: $400.0
Side Impacts: Selected	Price: $350.0
Power: Selected		Price: $350.0

TotalCost: $14660.0
 * 
 * 
 * 
 * */
