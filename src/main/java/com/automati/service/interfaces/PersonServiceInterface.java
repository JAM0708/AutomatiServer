package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Person;

public interface PersonServiceInterface {
	
	public void savePerson(Person person);
	
	public void deletePerson(Person person);
	
	public List<Person> getPeople();
	
	public void updatePerson(Person person);
	
	public Person getPerson(int index);
	
}
