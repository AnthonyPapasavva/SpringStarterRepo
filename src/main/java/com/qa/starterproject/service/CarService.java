package com.qa.starterproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.starterproject.Car;
import com.qa.starterproject.repo.CarRepo;

@Service
public class CarService {

	private Car car;

	@Autowired
	private CarRepo repo;

	public CarService() {
	}

	@Autowired
	public CarService(CarRepo repo) {
		this.repo = repo;
	}

	// Create (Add) Car
	public Car addCar(Car car) {
		return this.repo.save(car);
	}

	// Create (Add) Many Cars
	public List<Car> addManyCars(List<Car> cars) {
		return this.repo.saveAll(cars);
	}

	// Read (Find)
	// 'Optional' are objects that may or may not exist
	public Car findById(Long id) {
		Optional<Car> existingCar = this.repo.findById(id);
		if (existingCar.get() instanceof Car)
			return existingCar.get();
		return null;
	}

	// Read (Find) (All) Car
	public List<Car> readAllCars() {
		return this.repo.findAll();
	}

	// Update Car
	public Car updateCar(Car updateCar, Long id) {
		Optional<Car> existingCar = this.repo.findById(id);

		if (existingCar.get() instanceof Car) {
			Car oldCar = existingCar.get();

			oldCar.setColour(updateCar.getColour());
			oldCar.setModel(updateCar.getModel());
			oldCar.setName(updateCar.getName());
			oldCar.setWheels(updateCar.getWheels());

			return this.repo.save(oldCar);
		}

		return null;
	}

	// Delete Car
	public boolean deleteCar(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
}
