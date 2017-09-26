package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.dataentity.Role;
import com.automati.dataentity.State;
import com.automati.dataentity.ZipCode;

public interface PersonServiceInterface  extends GenericServiceInterface{
	
	public List<Person> getPeople();
	
	public Person getPerson(int index);

	public String getLoginToken(String email, String password);
	
	public List<ZipCode> getStateWithZipCodes(State state);
	
	public List<State> getAllStates();
	
	public Person findPersonByEmail(String email);
	
	public State findStateByName(String name);
	
	public Role findRoleByName(String name);
}
