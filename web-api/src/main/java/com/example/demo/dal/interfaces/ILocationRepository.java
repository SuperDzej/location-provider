package com.example.demo.dal.interfaces;

import com.example.demo.dal.models.Location;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILocationRepository extends MongoRepository<Location, String> {
    Location findById(ObjectId _id);
}
