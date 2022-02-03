package com.sensormanagement.Sensor.Models;

import java.time.LocalDateTime;
import java.util.List;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;
import org.json.JSONObject;

@Document(collection = "Sensor")
public class Model {


    @Id
    private String id;
    private String userId;
    private String sensorName;
    private String orgId;
    private boolean Status;
    private String threshold;
    private LocalDateTime creationTime;
    private String licenseId;

    @Nullable
    private JSONObject varkey;





    public Model() {
    }


    public Model(String id, String userId, String sensorName, String orgId, boolean status, String threshold, LocalDateTime creationTime, String licenseId, @Nullable JSONObject varkey) {
        this.id = id;
        this.userId = userId;
        this.sensorName = sensorName;
        this.orgId = orgId;
        Status = status;
        this.threshold = threshold;
        this.creationTime = creationTime;
        this.licenseId = licenseId;
        this.varkey = varkey;
    }


    @Nullable
    public JSONObject getVarkey() {
        return varkey;
    }

    public void setVarkey(@Nullable JSONObject varkey) {
        this.varkey = varkey;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

}
