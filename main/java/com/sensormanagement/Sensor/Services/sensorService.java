package com.sensormanagement.Sensor.Services;

import com.sensormanagement.Sensor.Models.Model;
import com.sensormanagement.Sensor.Repository.sensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class sensorService {
    @Autowired
    sensorRepository sr;
    public String create(Model request)
    {

        Model sensor = new Model();
        String opMsg = "";
        try
        {
            sensor.setId(request.getId());
            sensor.setUserId(request.getUserId());
            sensor.setCreationTime(request.getCreationTime());
            sensor.setOrgId(request.getOrgId());
            sensor.setSensorName(request.getSensorName());
            sensor.setStatus(true);
            sr.save(sensor);
            opMsg = "! New sensor saved to your repository !";

        }
        catch (Exception e)
        {
            opMsg = "!Exception occured in service !";
        }
        return opMsg;
    }

    public List<Model> getSensor() {
        List<Model> opSensor = null;
        try
        {
            opSensor = sr.findAll();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return opSensor;
    }

    public Optional<Model> getSensorById(String id) {
        Optional<Model> opSensor = null;
        try
        {
            opSensor = sr.findById(id);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return opSensor;
    }

    public String deleteSensor(String id) {
        String opMsg = "";
        try
        {
            sr.deleteById(id);
            opMsg = "! Sensor is Removed from your repository !";

        }
        catch (Exception e)
        {
            opMsg = "! Exception occurred while deleting the Sensor !";

        }
        return opMsg;
    }
}
