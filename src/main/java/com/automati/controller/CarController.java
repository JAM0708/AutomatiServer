package com.automati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.automati.dto.StatusCheck;
import com.automati.dto.TransmissionDTO;
import com.automati.service.interfaces.CarServiceInterface;
import com.automati.service.interfaces.PersonServiceInterface;

@RestController
public class CarController {
	
	@Autowired
	CarServiceInterface carService;
	
	@Autowired
	PersonServiceInterface personService;
	
	@RequestMapping(path="/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Car> getListofCarsByUser(@RequestParam("email") String email) {
		Person person = personService.findPersonByEmail(email);
		return carService.getCars(person);
	}
	
	@RequestMapping(path="/cars/model", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Car> getListofCarsByModel(@RequestParam("model") String model) {
		return carService.getCarsByModel(model);
	}
	
	@RequestMapping(path="/car", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck save(@RequestBody CarDTO carDTO) {
		Model model = carService.getModelByName(carDTO.getModel().getName());
		Color color = new Color(carDTO.getColor().getId(),  carDTO.getColor().getName());
		Transmission transmission =  carService.getTransmissionByName(carDTO.getTransmission().getName());
		Condition condition = carService.getConditionByType(carDTO.getCondition().getType());
		EPA epa = carService.getEPAByMileage(carDTO.getEpa().getMileage());
		Car car = new Car(carDTO.getYear(), model, color,  transmission, condition, epa, carDTO.getPrice());
		return carService.save(car); 
	}
	
	@RequestMapping(path="/model", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck  saveModel(@RequestBody ModelDTO modelDTO) {
		Model model = new Model(modelDTO.getName());
		return carService.save(model);
	}
	
	@RequestMapping(path="/transmission", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveTransmission(@RequestBody TransmissionDTO transmissionDTO) {
		Transmission transmisson = new Transmission(transmissionDTO.getName());
		return carService.save(transmisson);
	}
	
	@RequestMapping(path="/color", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveColor(@RequestBody ColorDTO colorDTO) {
		Color color = new Color(colorDTO.getName());
		return carService.save(color);
	}
	
	@RequestMapping(path="/feature", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveFeature(@RequestBody FeatureDTO featureDTO) {
		Feature feature = new Feature(featureDTO.getName());
		return carService.save(feature);
	}
	
	@RequestMapping(path="/lease", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveLease(@RequestBody LeaseDTO leaseDTO) {
		Lease feature = new Lease(leaseDTO);
		return carService.save(feature);
	}
	
	@RequestMapping(path="/epa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveEPA(@RequestBody EPADTO epaDTO) {
		EPA epa = new EPA(epaDTO.getMileage());
		return carService.save(epa);
	}
	
	@RequestMapping(path="/condition", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveCondition(@RequestBody ConditionDTO conditionDTO) {
		Condition condition = new Condition(conditionDTO);
		return carService.save(condition);
	}
	
	@RequestMapping(path="/models", method= RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Model> getAllModels() {
		return carService.getAllModels();
	}
	
	

}
