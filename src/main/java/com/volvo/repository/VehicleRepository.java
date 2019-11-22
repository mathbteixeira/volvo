package com.volvo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.volvo.model.Vehicle;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

	Optional<Vehicle> findByChassisId(String chassisId);

}
