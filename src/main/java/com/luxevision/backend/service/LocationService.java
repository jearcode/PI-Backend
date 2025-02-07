package com.luxevision.backend.service;

import com.luxevision.backend.entity.Location;
import com.luxevision.backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location saveLocation (Location location) {
        return locationRepository.save(location);
    }

    public Optional<Location> findLocationById (Integer id) {
        return locationRepository.findById(id);
    }

    public Location updateLocation (Location location) {
        return locationRepository.save(location);
    }

    public void deleteLocationById (Integer id) {
        locationRepository.deleteById(id);
    }

    public List<Location> findAllLocations () {
        return locationRepository.findAll();
    }

}
