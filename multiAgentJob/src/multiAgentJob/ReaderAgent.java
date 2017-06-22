package multiAgentJob;

import jade.core.*; 
import jade.core.behaviours.*; 
import jade.lang.acl.ACLMessage; 
import jade.domain.FIPAAgentManagement.ServiceDescription; 
import jade.domain.FIPAAgentManagement.DFAgentDescription; 
import jade.domain.DFService; 
import jade.domain.FIPAException;

public class ReaderAgent extends Agent{
	
	private static final long serialVersionUID = 1L;
	
	class readingText extends CyclicBehaviour {
		private static final long serialVersionUID = 2L;

		public readingText( Agent agent){
			super(agent);
		}
		
		@Override
		public void action() {
			System.out.println("Iniciar comportamento de leitura!");
			
			ACLMessage msg = myAgent.receive();
			
			if(msg != null) {
				System.out.println("Criando um resposta!");
				ACLMessage reply = msg.createReply();
				
				if (msg.getPerformative() == ACLMessage.REQUEST) {
					System.out.println("REQUEST!");
					String content = msg.getContent();
					System.out.println(getLocalName() + ": recebi " + content);
			
		}
		
	}
}
