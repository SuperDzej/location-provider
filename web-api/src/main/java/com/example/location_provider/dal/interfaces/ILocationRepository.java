package com.example.location_provider.dal.interfaces;

import com.example.location_provider.dal.models.Location;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILocationRepository extends MongoRepository<Location, String> {
    Location findById(ObjectId _id);
}
