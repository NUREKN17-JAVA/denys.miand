package ua.itcs.myand.usermanagement.agent;

import java.util.Collection;

import jade.core.behaviours.CyclicBehaviour;

public class RequestServer extends CyclicBehaviour {

	
	public void action() {
		ACLMessage message = myAgent.recieve();
			if (message != null) {
			if (message.getPerformative() == ACLMessage.REQUEST) {
				myAgent.send(createReply(message));
			} else {
				Collection users = parseMessage(message);
				((SearchAgent) myAgent).showUsers(users);
			}
			} else {
				block()
			}
	}

}
