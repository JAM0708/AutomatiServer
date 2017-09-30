package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		return carRepo.findCarByPerson(person);

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

}
