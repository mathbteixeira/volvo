package com.volvo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.volvo.dto.VehicleDTO;
import com.volvo.exception.ResourceNotFoundException;
import com.volvo.model.Vehicle;
import com.volvo.repository.VehicleRepository;
import com.volvo.utils.VehicleUtils;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleRepository repository;
	
	@GetMapping
	public List<VehicleDTO> getAll() {
		List<Vehicle> vehicles = repository.findAll();
		return VehicleDTO.converter(vehicles);
	}
	
	@GetMapping(value = "/{chassisId}")
    public Vehicle getOne(@PathVariable String chassisId) {
        return repository.findById(chassisId)
            .orElseThrow(() -> new ResourceNotFoundException());
    }
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Vehicle vehicle) {
		Boolean chassisIdExists = repository.findById(vehicle.getChassisId()).isPresent();
		if (!chassisIdExists) {
			vehicle.setNumPassengers(VehicleUtils.getNumPassengersByType(vehicle.getType()));
			Vehicle createdVehicle = repository.save(vehicle);
			return new ResponseEntity<String>("Created vehicle: " + createdVehicle.toString(), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("A vehicle with this chassisId already exists.", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@PutMapping(value = "/{chassisId}")
    public Vehicle update(@PathVariable String chassisId, @RequestBody Vehicle updatedVehicle) {
        Vehicle vehicle = repository.findById(chassisId)
            .orElseThrow(() -> new ResourceNotFoundException());
        vehicle.setColor(updatedVehicle.getColor());
        return repository.save(vehicle);
    }
	
	@DeleteMapping(value = "/{chassisId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> delete(@PathVariable String chassisId) {
        Vehicle vehicle = repository.findById(chassisId)
            .orElseThrow(() -> new ResourceNotFoundException());
        repository.delete(vehicle);
        return new ResponseEntity<String>("Vehicle with chassisId '" + vehicle.getChassisId() + "' deleted", HttpStatus.OK);
    }
}
