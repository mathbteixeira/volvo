package com.volvo.model;

import com.volvo.utils.VehicleUtils;

public class Truck extends Vehicle {
	
	public Truck(String chassisId, String color) {
		super(chassisId, VehicleUtils.TRUCK, (byte) 1, color);
	}
	
}