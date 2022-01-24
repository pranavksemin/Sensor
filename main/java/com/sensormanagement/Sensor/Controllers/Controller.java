package com.sensormanagement.Sensor.Controllers;


import com.sensormanagement.Sensor.Models.Model;
import com.sensormanagement.Sensor.Models.Response;
import com.sensormanagement.Sensor.Models.userModel;
import com.sensormanagement.Sensor.Services.sensorService;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    sensorService service;
    @PostMapping("/Sensor")
    public Response createSensor(@RequestBody Model sensor)
    {
        String msg="";
        LocalDateTime creationTime;
        creationTime = LocalDateTime.now();
        Response response = new Response();
        sensor.setStatus(true);

        sensor.setCreationTime(creationTime);
        String url = "http://localhost:8081/User/"+sensor.getUserId();

        System.out.println(sensor.getUserId());
        if(sensor!=null)
        {
            System.out.println(restTemplate.getForObject(url,userModel.class));
            if(restTemplate.getForObject(url,userModel.class) != null)
            {


                try {
                    msg = service.create(sensor);
                    response.setMsg(msg);
                    response.setSuccess(true);

                } catch (Exception e) {
                    response.setMsg(msg);
                    response.setSuccess(false);

                }
            }
            else
            {
                response.setMsg("! UserId cannot be found !");
                response.setSuccess(false);
            }


        }
        else
        {
            response.setMsg("Request cannot be Null");
            response.setSuccess(false);
        }
        return response;


    }


    @GetMapping("/Sensor")
    public List<Model> getAllSensors()
    {
        List<Model> opSensor = null;
        try
        {
            opSensor = service.getSensor();

        }
        catch (Exception e)
        {

        }
        return opSensor;
    }


    @GetMapping("/Sensor/{id}")
    public Optional<Model> getSensorById(@PathVariable String id)
    {
        Optional<Model> opSensor = null;
        if(id != null)
        {
            try
            {
                opSensor = service.getSensorById(id);

            }
            catch (Exception e)
            {

            }

        }
        else
        {

        }
        return opSensor;
    }

    @DeleteMapping("/Sensor/{id}")
    public Response deleteSensor(@PathVariable String id)
    {
        Response response = new Response();
        String opMsg = "";
        if(id != null)
        {
            try
            {
                opMsg = service.deleteSensor(id);
                response.setSuccess(true);
                response.setMsg(opMsg);
            }
            catch (Exception e)
            {
                response.setSuccess(false);
                response.setMsg(opMsg);
            }

        }
        else
        {
            opMsg = "! Sensor Id cannot be null !";
            response.setSuccess(false);
            response.setMsg(opMsg);
        }
        return response;
    }

}
