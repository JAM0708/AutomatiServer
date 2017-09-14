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
import com.automati.dataentity.Color;
import com.automati.dataentity.Condition;
import com.automati.dataentity.EPA;
import com.automati.dataentity.Feature;
import com.automati.dataentity.Lease;
import com.automati.dataentity.Model;
import com.automati.dataentity.Person;
import com.automati.dataentity.Transmission;
import com.automati.dto.CarDTO;
import com.automati.dto.ColorDTO;
import com.automati.dto.ConditionDTO;
import com.automati.dto.EPADTO;
import com.automati.dto.FeatureDTO;
import com.automati.dto.LeaseDTO;
import com.automati.dto.ModelDTO;
import com.automati.dto.PersonDTO;
import com.automati.dto.TransmissionDTO;
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
	
	@RequestMapping(path="/model", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveModel(@RequestBody ModelDTO modelDTO) {
		Model model = new Model(modelDTO.getName());
		carServiceInterface.saveModel(model);
	}
	
	@RequestMapping(path="/transmission", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveTransmission(@RequestBody TransmissionDTO transmissionDTO) {
		Transmission transmisson = new Transmission(transmissionDTO.getName());
		carServiceInterface.saveTransmission(transmisson);
	}
	
	@RequestMapping(path="/color", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveColor(@RequestBody ColorDTO colorDTO) {
		Color color = new Color(colorDTO.getName());
		carServiceInterface.saveColor(color);
	}
	
	@RequestMapping(path="/feature", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveFeature(@RequestBody FeatureDTO featureDTO) {
		Feature feature = new Feature(featureDTO.getName());
		carServiceInterface.saveFeature(feature);
	}
	
	@RequestMapping(path="/lease", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveLease(@RequestBody LeaseDTO leaseDTO) {
		Lease feature = new Lease(leaseDTO);
		carServiceInterface.saveLease(feature);
	}
	
	@RequestMapping(path="/epa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveEPA(@RequestBody EPADTO epaDTO) {
		EPA epa = new EPA(epaDTO.getMileage());
		carServiceInterface.saveEPA(epa);
	}
	
	@RequestMapping(path="/condition", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveCondition(@RequestBody ConditionDTO conditionDTO) {
		Condition condition = new Condition(conditionDTO);
		carServiceInterface.saveCondition(condition);
	}
	
	

}
