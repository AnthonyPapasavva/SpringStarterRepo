package com.qa.starterproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.starterproject.Car;
import com.qa.starterproject.service.CarService;

@RestController
@RequestMapping("/home")
public class CarController {

	@Autowired
	CarService service;

	// Print to the site?
	@GetMapping("/test")
	public String header() {
		return "<h1> Hello World </h1>" + "<br/>" + "<p> Hi </p>";
	}

	// Create
	@PostMapping("/createCar")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		Car createCar = service.addCar(car);
		return new ResponseEntity<Car>(createCar, HttpStatus.CREATED);
	}

	// Read
	@GetMapping("/read")
	public ResponseEntity<List<Car>> getCars() {
		List<Car> carData = service.readAllCars();
		return new ResponseEntity<List<Car>>(carData, HttpStatus.OK);
	}

	// Update
	@PutMapping("/updateCar/{id}")
	public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable Long id) {
		Car updateCar = service.updateCar(car, id);
		return new ResponseEntity<Car>(updateCar, HttpStatus.I_AM_A_TEAPOT);

	}

	// Delete
	@DeleteMapping("/deleteCar/{id}")
	public ResponseEntity<Boolean> deleteCar(@PathVariable Long id) {
		Boolean deletedCar = service.deleteCar(id);
		return (deletedCar) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}