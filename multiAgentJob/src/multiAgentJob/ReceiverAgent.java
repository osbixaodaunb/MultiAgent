package multiAgentJob;

import javax.swing.SwingUtilities;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.util.leap.ArrayList;

public class ReceiverAgent extends Agent {
	
	public boolean setVisible;
	//private ArrayList itemsGraph = new ArrayList();
	XYSeriesCollection dataset = new XYSeriesCollection();
	XYSeries series1 = new XYSeries("X axis", false);
	//XYSeries series2 = new XYSeries("Y axis");
	
	
	protected void setup() {
		
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new XYLineChart(dataset).setVisible(setVisible);
            }
        });
		
		addBehaviour(new CyclicBehaviour() {
			
			public void action() { 
				ACLMessage msg = receive();
				
				if(setVisible)
					setVisible = false;
				else
					setVisible = true;
				
				if (msg != null) {
					//mensagem recebida					
					Integer value = Integer.valueOf(msg.getContent()); //conteúdo da mensagem
					System.out.println(value);
					//itemsGraph.add(value); // Usa essa lista pra ser plotada no grafico
					for(int i = 0; i < series1.getItems().size() - 1; i++){
						series1.add(i, value);
						//System.out.println(itemsGraph.get(i));
					}
					
					dataset.addSeries(series1);
				
//			        SwingUtilities.invokeLater(new Runnable() {
//			            public void run() {
//			                new XYLineChart(dataset).setVisible(setVisible);
//			            }
//			        });
					
				}else {
					block();
				}
			}
		});
	}

}
