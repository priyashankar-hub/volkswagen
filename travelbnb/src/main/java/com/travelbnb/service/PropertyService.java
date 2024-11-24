package com.travelbnb.service;

import com.travelbnb.entity.Country;
import com.travelbnb.entity.Location;
import com.travelbnb.entity.Property;
import com.travelbnb.repository.CountryRepository;
import com.travelbnb.repository.LocationRepository;
import com.travelbnb.repository.PropertyRepository;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;
    private CountryRepository countryRepository;
    private LocationRepository locationRepository;

    public PropertyService(PropertyRepository propertyRepository, CountryRepository countryRepository, LocationRepository locationRepository) {
        this.propertyRepository = propertyRepository;
        this.countryRepository = countryRepository;
        this.locationRepository = locationRepository;
    }

    public Property saveProperty(Property property) {

        if (property.getCountry() != null && property.getCountry().getId() != null) {
            Country country = countryRepository.findById(property.getCountry().getId()).orElse(null);
            property.setCountry(country);
        }

        if (property.getLocation() != null && property.getLocation().getId() != null) {
            Location location = locationRepository.findById(property.getLocation().getId()).orElse(null);
            property.setLocation(location);
        }

//       return propertyRepository.save(property);

        Property savedProperty = propertyRepository.save(property);
        return savedProperty;
    }
}
