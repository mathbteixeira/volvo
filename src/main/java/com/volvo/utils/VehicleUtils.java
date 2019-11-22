package com.volvo.utils;

public class VehicleUtils {

	public static String BUS = "Bus";
	public static String CAR = "Car";
	public static String TRUCK = "Truck";
	
	public static Byte getNumPassengersByType(String type) {
		if (type.equals(VehicleUtils.BUS))
			return 42;
		else if (type.equals(VehicleUtils.CAR))
			return 4;
		else if (type.equals(VehicleUtils.TRUCK))
			return 1;
		else
			return null;
	}
}
