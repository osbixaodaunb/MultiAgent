package multiAgentJob;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.util.leap.ArrayList;

public class InsertAgent extends Agent{
	private ArrayList itemsGraph = new ArrayList();
	protected void setup() {
		addBehaviour(new TickerBehaviour(this, 2000) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onTick() {
				try
				{
				    String filename= "file.txt";
				    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				    Random randomNumber = new Random();
				    int value = randomNumber.nextInt(100);
				    String valueToBeInserted = Integer.toString(value);
				    valueToBeInserted = valueToBeInserted + "\n";
				    fw.write(valueToBeInserted);//appends the string to the file
				    fw.close();
				}
				catch(IOException ioe)
				{
				    System.err.println("IOException: " + ioe.getMessage());
				}
				
			}
		});
	}
}
