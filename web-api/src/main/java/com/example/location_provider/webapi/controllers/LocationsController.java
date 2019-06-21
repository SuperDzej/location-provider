package com.example.location_provider.webapi.controllers;

import com.example.location_provider.dal.models.Location;
import com.example.location_provider.bll.services.ILocationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LocationsController {
    private ILocationService _locationService;

    @Autowired
    public LocationsController(ILocationService locationService) {
        _locationService = locationService;
    }

    @RequestMapping(value="/locations", method = RequestMethod.GET)
    public List<Location> get() {
        return _locationService.get();
    }

    @RequestMapping(value="/locations/{id}", method = RequestMethod.GET)
    public Location getById(@PathVariable("id") ObjectId id) {
        return _locationService.getById(id);
    }

    @RequestMapping(value="/locations/filter", method = RequestMethod.GET)
    public List<Location> filter(@RequestParam ObjectId addressId, @RequestParam Double radius) {
        return _locationService.getByIdAndRadius(addressId, radius);
    }

    @RequestMapping(value="/locations", method = RequestMethod.POST)
    public Location create(@Valid @RequestBody Location location) {
        return _locationService.create(location);
    }

    @RequestMapping(value="/locations/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") ObjectId id, @Valid @RequestBody Location location) {
        _locationService.update(id, location);
    }

    @RequestMapping(value="/locations/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable ObjectId id) {
        _locationService.delete(id);
    }
}
