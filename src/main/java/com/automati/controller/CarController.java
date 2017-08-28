package com.automati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.dto.CarDTO;
import com.automati.dto.PersonDTO;
import com.automati.service.interfaces.CarServiceInterface;

@RestController
public class CarController {
	
	@Autowired
	CarServiceInterface carServiceInterface;
	
	@RequestMapping(path="/cars", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Car> getListofCarsByUser(@RequestBody PersonDTO personDTO) {
		Person person = new Person(personDTO.getId());
		return carServiceInterface.getCars(person);
	}
	
	@RequestMapping(path="/car", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void save(@RequestBody CarDTO carDTO) {
		Car car = new Car(carDTO.getYear(), carDTO.getModel(), carDTO.getColor(), 
				carDTO.getFeature(), carDTO.getTransmission(), carDTO.getCondition(),
				carDTO.getEpa(), carDTO.getPrice(), carDTO.getLease(), 
				carDTO.getReview(), carDTO.getPerson());
		carServiceInterface.saveCar(car);
	}


}
