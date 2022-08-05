package com.qa.starterproject;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Wheels")
	@Min(0)
	@Max(16)
	private int wheels;
	@Column(name = "Colour")
	private String colour;
	@Column(length = 20)
	@NotNull
	private String model;
	@Column(unique = true)
	@Size(min = 1, max = 20)
	private String name;

	@Autowired
	public Car() {
	}

	@Autowired
	public Car(int wheels, String colour, String model, String name) {
		this.wheels = wheels;
		this.colour = colour;
		this.model = model;
		this.name = name;
	}

	@Autowired
	public Car(Long id, int wheels, String colour, String model, String name) {
		this.id = id;
		this.wheels = wheels;
		this.colour = colour;
		this.model = model;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, model, name, wheels);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(colour, other.colour) && Objects.equals(model, other.model)
				&& Objects.equals(name, other.name) && wheels == other.wheels;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", wheels=" + wheels + ", colour=" + colour + ", model=" + model + ", name=" + name
				+ "]";
	}

}
