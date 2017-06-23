package multiAgentJob;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

public class ReceiverAgent extends Agent {
	
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {
			
			public void action() { 
				ACLMessage msg = receive();
				
				if (msg != null) {
					//mensagem recebida
					msg.getContent(); //conteúdo da mensagem
				}else {
					block();
				}
			}
		});
	}

}
