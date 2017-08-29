package com.automati.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.repo.CarRepo;
import com.automati.repo.ColorRepo;
import com.automati.repo.ConditionRepo;
import com.automati.repo.EpaRepo;
import com.automati.repo.FeatureRepo;
import com.automati.repo.LeaseRepo;
import com.automati.repo.ModelRepo;
import com.automati.repo.TransmissionRepo;
import com.automati.service.interfaces.CarServiceInterface;
import com.automati.dataentity.*;

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
	
	@Override
	public void saveCar(Car car) {
		carRepo.save(car);

	}

	@Override
	public Car getCar(int index) {
		// TODO update if not neeeded
		return carRepo.getOne(index);
	}

	@Override
	public List<Car> getCars(Person person) {
		// TODO get logger for class
		return carRepo.findCarByPerson(person);
		
	}

	@Override
	public void updateCar(Car car) {
		carRepo.saveAndFlush(car);
	}

	@Override
	public void deleteCar(Car car) {
		carRepo.delete(car);
	}

	@Override
	public void saveTransmission(Transmission transmission) {
		transmissionRepo.save(transmission);
	}

	@Override
	public void saveColor(Color color) {
		colorRepo.save(color);
	}

	@Override
	public void saveFeature(Feature feature) {
		featureRepo.save(feature);
	}

	@Override
	public void saveLease(Lease lease) {
		leaseRepo.save(lease);		
	}

	@Override
	public void saveEPA(EPA epa) {
		epaRepo.save(epa);
	}

	@Override
	public void saveModel(Model model) {
		modelRepo.save(model);
	}

	@Override
	public void saveCondition(Condition condition) {
		conditionRepo.save(condition);
	}
	
}
