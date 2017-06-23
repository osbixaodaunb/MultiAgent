package multiAgentJob;

import javax.swing.JFrame;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.util.leap.ArrayList;

public class ReceiverAgent extends Agent {
	private ArrayList itemsGraph = new ArrayList();
	int [] data = new int[3];
	JFrame f = new JFrame();

	protected void setup() {
		data[0] = 1;
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.add(new GraphingData(data));
	    f.setSize(400,400);
	    f.setLocation(200,200);
	    f.setVisible(true);
		addBehaviour(new CyclicBehaviour() {
			
			public void action() { 
				ACLMessage msg = receive();
				
				if (msg != null) {
					//mensagem recebida					
					int value = Integer.valueOf(msg.getContent()); //conteúdo da mensagem
					System.out.println(value);
					itemsGraph.add(value); // Usa essa lista pra ser plotada no grafico
					data = new int[itemsGraph.size()];
					for(int i = 0; i < itemsGraph.size() - 1; i++){
						System.out.println(itemsGraph.get(i));
						data[i] = (int)itemsGraph.get(i);
					}
					
					
				}else {
					block();
				}
			}
		});
	}

}
