package com.sensormanagement.Sensor.Repository;

import com.sensormanagement.Sensor.Models.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface sensorRepository extends MongoRepository<Model,String> {

}
