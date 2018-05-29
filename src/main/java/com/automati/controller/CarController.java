package com.automati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Car>> getListofCarsByUser(@RequestParam("email") String email) {
		Person person = personService.findPersonByEmail(email);
		return new ResponseEntity<List<Car>>(carService.getCars(person), HttpStatus.OK);
	}
	
	@RequestMapping(path="/car", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Car> findCarById(@RequestParam("id") int id) {
		return new ResponseEntity<Car>(carService.getCarById(id), HttpStatus.OK);
	}
	
	@RequestMapping(path="/cars/model", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Car>> getListofCarsByModel(@RequestParam("model") String model) {
		return new ResponseEntity<List<Car>>(carService.getCarsByModel(model), HttpStatus.OK);
	}
	
	@RequestMapping(path="/car/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> save(@RequestBody CarDTO carDTO) {
		Model model = carService.getModelByName(carDTO.getModel().getName());
		Color color = carService.getColorByName(carDTO.getColor().getName());
		Transmission transmission =  carService.getTransmissionByName(carDTO.getTransmission().getName());
		Condition condition = carService.getConditionByType(carDTO.getCondition().getType());
		Person person = personService.findPersonByEmail(carDTO.getPerson().getEmail());
		Engine engine = carService.getEngine(carDTO.getEngine().getId());
		//EPA epa = carService.getEPAByMileage(carDTO.getEpa().getMileage());
		carDTO.setVin(carService.setVin());
		Car car = new Car(carDTO.getYear(), carDTO.getMileage(), carDTO.getTitle(),  model, color,  transmission, condition, carDTO.getPrice(), carDTO.getVin(), person, engine);
		return new ResponseEntity<StatusCheck>(carService.save(car), HttpStatus.OK); 
	}
	
	@RequestMapping(path="/car/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
	public ResponseEntity<StatusCheck>  saveModel(@RequestBody ModelDTO modelDTO) {
		Model model = new Model(modelDTO.getName());
		return new ResponseEntity<StatusCheck>(carService.save(model), HttpStatus.OK);
	}
	
	@RequestMapping(path="/transmission", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> saveTransmission(@RequestBody TransmissionDTO transmissionDTO) {
		Transmission transmisson = new Transmission(transmissionDTO.getName());
		return new ResponseEntity<StatusCheck>(carService.save(transmisson), HttpStatus.OK);
	}
	
	@RequestMapping(path="/color", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> saveColor(@RequestBody ColorDTO colorDTO) {
		Color color = new Color(colorDTO.getName());
		return new ResponseEntity<StatusCheck>(carService.save(color), HttpStatus.OK);
	}
	
	@RequestMapping(path="/feature", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> saveFeature(@RequestBody FeatureDTO featureDTO) {
		Feature feature = new Feature(featureDTO.getName());
		return new ResponseEntity<StatusCheck>(carService.save(feature), HttpStatus.OK);
	}
	
	@RequestMapping(path="/epa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> saveEPA(@RequestBody EPADTO epaDTO) {
		EPA epa = new EPA(epaDTO.getMileage());
		return new ResponseEntity<StatusCheck>(carService.save(epa), HttpStatus.OK);
	}
	
	@RequestMapping(path="/condition", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusCheck> saveCondition(@RequestBody ConditionDTO conditionDTO) {
		Condition condition = new Condition(conditionDTO);
		return new ResponseEntity<StatusCheck>(carService.save(condition), HttpStatus.OK);
	}
	
	@RequestMapping(path="/models", method= RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Model>> getAllModels() {
		return new ResponseEntity<List<Model>>(carService.getAllModels(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/colors", method= RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Color>> getAllColors() {
		return new ResponseEntity<List<Color>>(carService.getAllColors(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/color", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Color> getColor(@RequestParam("name") String name) {
		return new ResponseEntity<Color>(carService.getColorByName(name), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/car/model", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Model> getModel(@RequestParam("name") String name) {
		return new ResponseEntity<Model>(carService.getModelByName(name), HttpStatus.OK);
	}
	
	@RequestMapping(path="/transmissions", method= RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transmission>> getAllTransmissions() {
		return new ResponseEntity<List<Transmission>>(carService.getAllTransmissions(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/transmission", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transmission> getTransmission(@RequestParam("id") int id) {
		return new ResponseEntity<Transmission>(carService.getTransmission(id), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/engine", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Engine> getEngineById(@RequestParam("id") int id) {
		return new ResponseEntity<Engine>(carService.getEngine(id), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/engines", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Engine>> getEngines() {
		return new ResponseEntity<List<Engine>>(carService.getAllEngines(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/features", method= RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Feature>> getAllFeatures() {
		return new ResponseEntity<List<Feature>>(carService.getAllFeatures(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/carsByPerson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Car>> getCarsByPerson(@RequestParam("email") String email) {
		Person person = personService.findPersonByEmail(email);
		return new ResponseEntity<List<Car>>(carService.getCarsByPerson(person), HttpStatus.OK);
	}
}
