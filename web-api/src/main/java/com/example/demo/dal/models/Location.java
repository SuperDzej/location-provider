package com.example.demo.dal.models;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Location {
    @Id
    private ObjectId id;

    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotNull
    @Size(min = 1, max = 50)
    private String locationName;

    public Location(ObjectId id, Double latitude, Double longitude, String locationName) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
    }

    public String getId() { return id.toHexString(); }
    public void setId(ObjectId id) { this.id = id; }

    public Double getLatitude() { return latitude; }
    public void setlatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setlongitude(Double longitude) { this.longitude = longitude; }

    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }
}
