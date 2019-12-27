package ua.itcs.myand.usermanagement.agent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import ua.itcs.myand.usermanagement.User;
import ua.itcs.myand.usermanagement.db.DaoFactory;
import ua.itcs.myand.usermanagement.db.DatabaseException;

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
	
	private Collection parseMessage (ACLMessage message) {
		return null;
	}
	
	private ACLMessage createReply (ACLMessage message) {
		ACLMessage reply = message.createReply();
		
		String content= message.getContent();
		StringTokenizer tokenizer = new StringTokenizer (content, ",");
		if (tokenizer.countTokens() == 2) {
			String firstName = tokenizer.nextToken();
			String lastName = tokenizer.nextToken();
			Collection users = null;
			try {
				users = DaoFactory.getInstance().getUserDao().find(firstName, lastName);
			} catch (DatabaseException e) {
				e.printStackTrace();
				users = new ArrayList(0);
			}
			
			StringBuffer buffer = new StringBuffer();
			for  (Iterator it = users.iterator(); it.hasNext();) {
				User user = (User) it.next();
				buffer.append(user.getId()).append(",");
				buffer.append(user.getFirstName()).append(",");
				buffer.append(user.getLastName()).append(";");
			}
			reply.setContent(buffer.toString());
		}
		
		return reply;
	}

}
