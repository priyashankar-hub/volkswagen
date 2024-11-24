package com.travelbnb.repository;

import com.travelbnb.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    //@Query("Select p from property p JOIN Location l on p.location = l.id where l.name =:locationName ")

    List<Property> searchProperty(@Param("locationName") String locationName);
}