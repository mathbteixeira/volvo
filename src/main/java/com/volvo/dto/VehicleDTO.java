package com.volvo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.volvo.model.Vehicle;

public class VehicleDTO {

	private String chassisId;
	private String type;
	private Byte numPassengers;
	private String color;
	
	public VehicleDTO(Vehicle vehicle) {
		this.chassisId = vehicle.getChassisId();
		this.type = vehicle.getType();
		this.numPassengers = vehicle.getNumPassengers();
		this.color = vehicle.getColor();
	}
	
	public String getChassisId() {
		return chassisId;
	}
	public void setChassisId(String chassisId) {
		this.chassisId = chassisId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Byte getNumPassengers() {
		return numPassengers;
	}
	public void setNumPassengers(Byte numbPassengers) {
		this.numPassengers = numbPassengers;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public static List<VehicleDTO> converter(List<Vehicle> vehicles) {
		return vehicles.stream().map(VehicleDTO::new).collect(Collectors.toList());
	}
}
