package com.qa.starterproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.starterproject.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

	@Query(value = "SELECT * FROM car", nativeQuery = true)
	public List<Car> allFromCar();

	@Query(value = "SELECT * FROM car WHERE name = ?1", nativeQuery = true)
	public List<Car> sameNameSelect(String name);
}
