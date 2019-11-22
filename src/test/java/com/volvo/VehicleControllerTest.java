package com.volvo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.volvo.controller.VehicleController;
import com.volvo.dto.VehicleDTO;
import com.volvo.model.Vehicle;
import com.volvo.repository.VehicleRepository;
import com.volvo.utils.VehicleUtils;

import junit.framework.TestCase;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class VehicleControllerTest extends TestCase {

	//@Mock
	private VehicleRepository mockRepository;
	
	//@InjectMocks
	private VehicleController mockController;
	
	@Test
	public void testGetAll() {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(new Vehicle("abc123-0002", VehicleUtils.CAR, (byte) 4, "Brown"));
		//vehicles.add(new Vehicle("abc123-0003", VehicleUtils.CAR, (byte) 4, "Green"));
		when(mockRepository.findAll()).thenReturn(vehicles);
		List<VehicleDTO> list = mockController.getAll();
		assertEquals(vehicles, list);
	}
	
	@Test
	public void testAdd() {
		Vehicle vehicle = new Vehicle("abc123-0002", VehicleUtils.CAR, (byte) 4, "Brown");
		ResponseEntity<String> response = mockController.add(vehicle);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("Created vehicle: ", response.getBody().startsWith("Created vehicle: "));
		//when(mockRepository.findById(vehicle.getChassisId())).thenReturn(any(Optional.class));
	}
}
