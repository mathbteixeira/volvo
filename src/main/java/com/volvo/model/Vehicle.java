package com.volvo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicle")
public class Vehicle {

	@Id
	private String chassisId;
	
	private String type;
	
	private Byte numPassengers;
	
	private String color;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String chassisId, String type, Byte numPassengers, String color) {
		this.chassisId = chassisId;
		this.type = type;
		this.numPassengers = numPassengers;
		this.color = color;
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
	
	@Override
    public String toString() {
        return "Vehicle{" +
                " chassisId='" + chassisId + '\'' +
                ", type='" + type + '\'' +
                ", numPassengers='" + numPassengers + '\'' +
                ", color=" + color +
                '}';
    }
}
