package com.qa.starterproject;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Drivers")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long driverId;

	@Size(min = 2, max = 12)
	@NotNull
	private String name;

	@Min(0)
	@Max(80)
	private int age;

	public Driver() {
	}

	public Driver(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Driver(Long driverId, String name, int age) {
		this.driverId = driverId;
		this.name = name;
		this.age = age;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", age=" + age + "]";
	}

//	public Driver() {
//		System.out.println("Driver created");
//	}

}
