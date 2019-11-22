package com.volvo.model;

import com.volvo.utils.VehicleUtils;

public class Car extends Vehicle {
	
	public Car(String chassisId, String color) {
		super(chassisId, VehicleUtils.CAR, (byte) 4, color);
	}
	
}