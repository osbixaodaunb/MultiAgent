package multiAgentJob;

import jade.core.*; 
import jade.core.behaviours.*; 
import jade.lang.acl.ACLMessage;

public class ReaderAgent extends Agent{
	
	
	protected void setup() { 
		addBehaviour(new OneShotBehaviour() {
			
			public void action() {
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.setContent("Message content");
				msg.addReceiver(new AID("second",AID.ISLOCALNAME));
				send(msg);
			}
		});
	}
}
