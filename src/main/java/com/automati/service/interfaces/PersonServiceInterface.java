package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.dataentity.Role;
import com.automati.dataentity.State;
import com.automati.dataentity.ZipCode;

public interface PersonServiceInterface {
	
	public void savePerson(Person person);
	
	public void deletePerson(Person person);
	
	public List<Person> getPeople();
	
	public void updatePerson(Person person);
	
	public Person getPerson(int index);

	public String getLoginToken(String email, String password);
	
	public void saveState(State state);
	
	public void saveZipCode(ZipCode zipcode);
	
	public void saveRole(Role role);
	
	public List<ZipCode> getStateWithZipCodes(State state);
	
	public List<State> getAllStates();
	
	public Person findPersonByEmail(String email);
	
	public State findStateByName(String name);
	
	public Role findRoleByName(String name);
}
