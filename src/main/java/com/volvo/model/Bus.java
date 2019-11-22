package com.volvo.model;

import com.volvo.utils.VehicleUtils;

public class Bus extends Vehicle {
	
	public Bus(String chassisId, String color) {
		super(chassisId, VehicleUtils.BUS, (byte) 42, color);
	}
	
}
