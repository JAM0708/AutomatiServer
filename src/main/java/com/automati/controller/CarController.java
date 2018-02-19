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
import com.automati.dataentity.Engine;
import com.automati.dataentity.Feature;
import com.automati.dataentity.Lease;
import com.automati.dataentity.Model;
import com.automati.dataentity.Person;
import com.automati.dataentity.Review;
import com.automati.dataentity.Role;
import com.automati.dataentity.State;
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
	
	@RequestMapping(path="/car", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Car findCarById(@RequestParam("id") int id) {
		return carService.getCarById(id);
	}
	
	@RequestMapping(path="/cars/model", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Car> getListofCarsByModel(@RequestParam("model") String model) {
		return carService.getCarsByModel(model);
	}
	
	@RequestMapping(path="/car/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck save(@RequestBody CarDTO carDTO) {
		Model model = carService.getModelByName(carDTO.getModel().getName());
		Color color = carService.getColorByName(carDTO.getColor().getName());
		Transmission transmission =  carService.getTransmissionByName(carDTO.getTransmission().getName());
		Condition condition = carService.getConditionByType(carDTO.getCondition().getType());
		Person person = personService.findPersonByEmail(carDTO.getPerson().getEmail());
		Engine engine = carService.getEngine(carDTO.getEngine().getId());
		//EPA epa = carService.getEPAByMileage(carDTO.getEpa().getMileage());
		Car car = new Car(carDTO.getYear(), carDTO.getMileage(), carDTO.getTitle(),  model, color,  transmission, condition, carDTO.getPrice(), carDTO.getVin(), person, engine);
		return carService.save(car); 
	}
	
	@RequestMapping(path="/car/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateCar(@RequestBody CarDTO carDTO) {
		Model model = carService.getModelByName(carDTO.getModel().getName());
		Color color = carService.getColorByName(carDTO.getColor().getName());
		Transmission transmission =  carService.getTransmissionByName(carDTO.getTransmission().getName());
		Condition condition = carService.getConditionByType(carDTO.getCondition().getType());
		//EPA epa = carService.getEPAByMileage(carDTO.getEpa().getMileage());
		Person person = personService.findPersonByEmail(carDTO.getPerson().getEmail());
		Car car = new Car(carDTO.getId(), carDTO.getYear(), carDTO.getMileage(), carDTO.getTitle(),  model, color,  transmission, condition, carDTO.getPrice(), person);
		System.out.println(car.toString());
		carService.update(car);
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
	
	@RequestMapping(path="/colors", method= RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Color> getAllColors() {
		return carService.getAllColors();
	}
	
	@RequestMapping(path = "/color", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Color getColor(@RequestParam("name") String name) {
		return carService.getColorByName(name);
	}
	
	@RequestMapping(path = "/car/model", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Model getModel(@RequestParam("name") String name) {
		return carService.getModelByName(name);
	}
	
	@RequestMapping(path="/transmissions", method= RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Transmission> getAllTransmissions() {
		return carService.getAllTransmissions();
	}
	
	@RequestMapping(path = "/transmission", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Transmission getTransmission(@RequestParam("id") int id) {
		return carService.getTransmission(id);
	}
	
	@RequestMapping(path = "/engine", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Engine getEngineById(@RequestParam("id") int id) {
		return carService.getEngine(id);
	}
	
	@RequestMapping(path = "/engines", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Engine> getEngines() {
		return carService.getAllEngines();
	}
	
	@RequestMapping(path="/features", method= RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Feature> getAllFeatures() {
		return carService.getAllFeatures();
	}
	
	@RequestMapping(path="/carsByPerson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Car> getCarsByPerson(@RequestParam("email") String email) {
		Person person = personService.findPersonByEmail(email);
		return carService.getCarsByPerson(person);
	}
}
