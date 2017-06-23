package multiAgentJob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import jade.util.leap.ArrayList;

public class Database {

	private ArrayList array = new ArrayList();
	
	public Database(String nameFile) throws IOException{
		readFile(nameFile);
	}
	
	private void readFile(String nameFile) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(nameFile));

		try {


		    String line = br.readLine();

		    while (line != null) {
			    StringBuilder sb = new StringBuilder();
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        array.add(sb.toString());

		        line = br.readLine();
		    }
		    
		}catch ( NullPointerException e){
		    br.close();
		}
	}
	
	public String getRandomElement(){
	
		Random randomGenerator = new Random();
		int indexGenerated = randomGenerator.nextInt(array.size()-1);
		String actualContent = (String) array.get(indexGenerated);
		return actualContent;
	}
	
	
}
