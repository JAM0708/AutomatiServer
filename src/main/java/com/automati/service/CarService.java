package com.automati.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.repo.CarRepo;
import com.automati.repo.ColorRepo;
import com.automati.repo.ConditionRepo;
import com.automati.repo.EngineRepo;
import com.automati.repo.EpaRepo;
import com.automati.repo.FeatureRepo;
import com.automati.repo.LeaseRepo;
import com.automati.repo.ModelRepo;
import com.automati.repo.TransmissionRepo;
import com.automati.service.interfaces.CarServiceInterface;
import com.automati.dataentity.*;
import com.automati.dto.StatusCheck;

@Service
@Transactional
public class CarService implements CarServiceInterface {

	@Autowired
	private CarRepo carRepo;

	@Autowired
	private TransmissionRepo transmissionRepo;

	@Autowired
	private ColorRepo colorRepo;

	@Autowired
	private FeatureRepo featureRepo;

	@Autowired
	private LeaseRepo leaseRepo;

	@Autowired
	private EpaRepo epaRepo;

	@Autowired
	private ModelRepo modelRepo;

	@Autowired
	private ConditionRepo conditionRepo;
	
	@Autowired
	private EngineRepo engineRepo;
	
	@Autowired
	@Qualifier("status-check")
	private StatusCheck status;

	@Override
	public Car getCar(int index) {
		// TODO update if not neeeded
		return carRepo.getOne(index);
	}

	@Override
	public List<Car> getCars(Person person) {
		// TODO get logger for class
		List<Car> results = carRepo.findCarsByPerson(person);
		//results.forEach(line->System.out.println(line.getFeature()));
		return results;

	}

	@Override
	public <T> StatusCheck save(T object) {
		boolean passed = false;
		if (object instanceof Car) {
			carRepo.save((Car) object);
			passed = true;
		} else if (object instanceof Transmission) {
			transmissionRepo.save((Transmission) object);
			passed = true;
		} else if (object instanceof Color) {
			colorRepo.save((Color) object);
			passed = true;
		} else if (object instanceof Feature) {
			featureRepo.save((Feature) object);
			passed = true;
		} else if (object instanceof Lease) {
			leaseRepo.save((Lease) object);
			passed = true;
		} else if (object instanceof EPA) {
			epaRepo.save((EPA) object);
			passed = true;
		} else if (object instanceof Model) {
			modelRepo.save((Model) object);
			passed = true;
		} else if (object instanceof Condition) {
			conditionRepo.save((Condition) object);
			passed = true;
		}
		if(passed) {
		status.setPassedTrue();
		return status;
		} else {
			status.setPassedFalse();
			return status;
		}
	}

	@Override
	public <T> void delete(T object) {
		if (object instanceof Car) {
			carRepo.delete((Car) object);
		}
	}

	@Override
	public <T> void update(T object) {
		if (object instanceof Car) {
			carRepo.save((Car) object);
		}

	}

	@Override
	public List<Model> getAllModels() {
		return modelRepo.findAll();
	}

	@Override
	public List<Car> getCarsByModel(String modelName) {
		Model model = modelRepo.findModelByName(modelName);
		List<Car> carsByModel = carRepo.findCarByModel(model);
		
		// lambda
		//carsByModel.forEach(car->System.out.println(car.getFeature()));
		carsByModel.forEach(car->System.out.println(car.toString()));
		List<Car> results = carsByModel.stream().filter(car -> car.getPerson() == null).collect(Collectors.toList()); 
		results.forEach(car -> System.out.println(car.toString()));
		return results;

	}
	
	@Override
	public Model getModelByName(String name) {
		return modelRepo.findModelByName(name);
	}

	@Override
	public Transmission getTransmissionByName(String name) {
		return transmissionRepo.findTransmissionByName(name);
	}

	@Override
	public Condition getConditionByType(String type) {
		return conditionRepo.findConditionByType(type);
	}

	@Override
	public EPA getEPAByMileage(int mileage) {
		return epaRepo.findEPAByMileage(mileage);
	}

	@Override
	public Car getCarById(int id) {
		Car car = carRepo.findOne(id);
		System.out.println(car.getFeature());
		System.out.println(car.getReview());
		return car;
	}

	@Override
	public List<Color> getAllColors() {
		return colorRepo.findAll();
	}

	@Override
	public List<Transmission> getAllTransmissions() {
		return transmissionRepo.findAll();
	}

	@Override
	public List<Feature> getAllFeatures() {
		return featureRepo.findAll();
	}

	@Override
	public Color getColorByName(String name) {
		// TODO Auto-generated method stub
		return colorRepo.findColorByName(name);
	}

	@Override
	public Transmission getTransmission(int id) {
		// TODO Auto-generated method stub
		return transmissionRepo.findOne(id);
	}

	@Override
	public Engine getEngine(int id) {
		// TODO Auto-generated method stub
		return engineRepo.findOne(id);
	}

	@Override
	public List<Engine> getAllEngines() {
		// TODO Auto-generated method stub
		return engineRepo.findAll();
	}

	@Override
	public List<Car> getCarsByPerson(Person person) {
		// TODO Auto-generated method stub
		List<Car> cars = carRepo.findCarsByPerson(person);
		
		List<Car> results = cars.stream().filter(car -> car.isReviewed() == false).collect(Collectors.toList()); 

		return results;
	}


}
