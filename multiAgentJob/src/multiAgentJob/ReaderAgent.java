package multiAgentJob;

import java.io.IOException;

import jade.core.*; 
import jade.core.behaviours.*; 
import jade.lang.acl.ACLMessage;

public class ReaderAgent extends Agent{
	
	Database database;
	
	protected void setup() { 
		addBehaviour(new OneShotBehaviour() {
			
			public void action() {
				
				try {
					database = new Database("file.txt");
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch ( NullPointerException e) {
					e.printStackTrace();
				}
				
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				String dados = database.getRandomElement();
				msg.setContent(dados);
				msg.addReceiver(new AID("receiverAgent",AID.ISLOCALNAME));
				send(msg);
			}
		});
	}
}
