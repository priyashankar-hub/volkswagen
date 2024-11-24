package com.travelbnb.controller;

import com.travelbnb.entity.Property;
import com.travelbnb.repository.PropertyRepository;
import com.travelbnb.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

    private PropertyService propertyService;
    private PropertyRepository propertyRepository;

    public PropertyController(PropertyService propertyService,
                              PropertyRepository propertyRepository) {
        this.propertyService = propertyService;
        this.propertyRepository = propertyRepository;
    }

    @PostMapping("/addProperties")
    public ResponseEntity<?> addProperty(@RequestBody Property property) {

        Property savedProperty=propertyService.saveProperty(property);


        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);

    }
    @GetMapping("/search/properties")
    public ResponseEntity<List<Property>> searchProperty(@RequestParam String name){
        List<Property> properties = propertyRepository.searchProperty(name);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

}
