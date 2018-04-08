package com.automati.service.interfaces;

import java.util.List;

import org.thymeleaf.context.Context;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.dataentity.ResetToken;
import com.automati.dataentity.Role;
import com.automati.dataentity.Shipping;
import com.automati.dataentity.State;
import com.automati.dataentity.ZipCode;
import com.automati.dto.JwtDTO;
import com.automati.dto.StatusCheck;

public interface PersonServiceInterface  extends GenericServiceInterface{
	
	public List<Person> getPeople();
	
	public Person getPerson(int index);

	public JwtDTO getLoginToken(String email, String password);
	
	public List<ZipCode> getStateWithZipCodes(State state);
	
	public List<State> getAllStates();
	
	public Person findPersonByEmail(String email);
	
	public State findStateByName(String name);
	
	public Role findRoleByName(String name);
	
	public List<Shipping> findShippingsByPerson(Person person);
	
	public Shipping findShippingAddressById(int id);

	StatusCheck sendEmail(String email, Context ctx, String emailTemplate, String image, String subject);

	StatusCheck storeToken(ResetToken resetToken);

	ResetToken findToken(ResetToken resetToken);

	public void resetPassword(Person person);

	public void deleteTokens(String email);
}
