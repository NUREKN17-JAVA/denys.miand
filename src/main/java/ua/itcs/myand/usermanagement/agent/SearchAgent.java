package ua.itcs.myand.usermanagement.agent;

import java.util.Collection;

import jade.core.Agent;
import ua.itcs.myand.usermanagement.db.DaoFactory;
import ua.itcs.myand.usermanagement.db.DatabaseException;

public class SearchAgent extends Agent {

	
	protected void setup() {
		super.setup();
		System.out.println(getAID().getName() + "started");
	}
	
	
	protected void takeDown() {	
		System.out.println(getAID().getName() + "terminated.");
		super.takeDown();
		
	}

	public void search (String firstName, String lastName) throws SearchException {
		
		Collection users = DaoFactory.getInstance().getUserDao().find(firstName, lastName);
		if (users.size() > 0) {
		showUsers(users);
	} else {
		//TODO послать запрос другим агентам.
	}
		catch (DatabaseException e) {
		throw new SearchException(e);
	}
}

private void showUsers(Collection user) {
	//TODO отобразить найденных пользователь
}