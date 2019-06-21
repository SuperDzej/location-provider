package com.example.location_provider.bll.services;

import com.example.location_provider.dal.models.Location;
import org.bson.types.ObjectId;

import java.util.List;

public interface ILocationService {
    List<Location> get();
    Location getById(ObjectId id);
    Location create(Location location);
    void update(ObjectId id, Location location);
    void delete(ObjectId id);
    List<Location> getByIdAndRadius(ObjectId id, Double radius);
}
