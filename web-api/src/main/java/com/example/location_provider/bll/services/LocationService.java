package com.example.location_provider.bll.services;

import com.example.location_provider.bll.helpers.GeolocationCalculator;
import com.example.location_provider.dal.models.Location;
import com.example.location_provider.dal.interfaces.ILocationRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.stream.Collectors;

@Service
public class LocationService implements ILocationService {
    private ILocationRepository _locationRepository;
    private Logger logger = LoggerFactory.getLogger(LocationService.class);

    @Autowired
    public LocationService(ILocationRepository repository) {
        _locationRepository = repository;
    }

    public List<Location> get() {
        return _locationRepository.findAll();
    }

    public Location getById(ObjectId id) {
        return _locationRepository.findById(id);
    }

    public Location create(Location location) {
        location.setId(ObjectId.get());
        _locationRepository.save(location);
        return location;
    }

    public void update(ObjectId id, Location location) {
        location.setId(id);
        _locationRepository.save(location);
    }

    public void delete(ObjectId id) {
        _locationRepository.delete(_locationRepository.findById(id));
    }

    public List<Location> getByIdAndRadius(ObjectId id, Double radius) {
        Location centralLocation = _locationRepository.findById(id);
        if(centralLocation == null) {
            return new ArrayList<>();
        } else {
            logger.info("Filtering locations withing radius " + radius);
            List<Location> locations = _locationRepository.findAll();
            return locations.stream()
                    .filter(location -> GeolocationCalculator.isWithinDistanceFromCenter(centralLocation.getLatitude(), centralLocation.getLongitude(),
                        location.getLatitude(), location.getLongitude(), radius))
                    .collect(Collectors.toList());
        }
    }
}
