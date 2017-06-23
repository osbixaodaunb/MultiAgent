package multiAgentJob;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.util.leap.ArrayList;

public class ReceiverAgent extends Agent {
	private ArrayList itemsGraph = new ArrayList();
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {
			
			public void action() { 
				ACLMessage msg = receive();
				
				if (msg != null) {
					//mensagem recebida					
					int value = Integer.valueOf(msg.getContent()); //conteúdo da mensagem
					System.out.println(value);
					itemsGraph.add(value); // Usa essa lista pra ser plotada no grafico
					for(int i = 0; i < itemsGraph.size() - 1; i++){
						System.out.println(itemsGraph.get(i));
					}
				}else {
					block();
				}
			}
		});
	}

}
