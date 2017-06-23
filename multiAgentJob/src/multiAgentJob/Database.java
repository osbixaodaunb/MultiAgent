package multiAgentJob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import jade.util.leap.ArrayList;

public class Database {
	private ArrayList contents;
	
	public Database(String nameFile) throws IOException{
		readFile(nameFile);
	}
	
	public ArrayList getContents(){
		return this.contents;
	}
	
	private void readFile(String nameFile) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(nameFile));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    contents.add(everything);
		} finally {
		    br.close();
		}
	}
	
	public String getRandomElement(){
		Random randomGenerator = new Random();
		int contentsLength = contents.size();
		int indexGenerated = randomGenerator.nextInt(contentsLength);
		String actualContent = (String) contents.get(indexGenerated);
		return actualContent;
	}
	
	
}
