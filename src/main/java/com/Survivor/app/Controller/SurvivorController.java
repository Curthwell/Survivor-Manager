package com.Survivor.app.Controller;

import com.Survivor.app.Entity.Location;
import com.Survivor.app.Entity.Survivor;
import com.Survivor.app.Service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/survivors")
public class SurvivorController {
    private final SurvivorService survivorService;
    @Autowired
    public SurvivorController(SurvivorService survivorService) {
        this.survivorService = survivorService;
    }

    @PostMapping
    public ResponseEntity<Survivor> saveSurvivor(@RequestBody Survivor survivor) {
        Survivor savedSurvivor = survivorService.saveSurvivor(survivor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSurvivor);
    }

    @PutMapping("/{id}/location")
    public ResponseEntity<String> updateSurvivorLocation(
            @PathVariable("id") Long id,
           @RequestBody Location location) {

        // Process the latitude and longitude parameters
        // Pass survivorId, latitude, and longitude to the service
        survivorService.updateSurvivorLocation(id, location);
        return ResponseEntity.ok("Survivor location updated successfully.");
    }
    @GetMapping
    public ResponseEntity<List<Survivor>> findAllSurvivors() {
        List<Survivor> survivors = survivorService.findAllSurvivor();
        return new ResponseEntity<>(survivors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Survivor> findById(@PathVariable("id") Long id) {
        return survivorService.findById(id);
    }
    @PutMapping("/{id}/flagInfected")
    public ResponseEntity<String> flagSurvivorAsInfected(@PathVariable("id") Long id) {
        Survivor survivor = survivorService.flagSurvivorAsInfected(id);
        if (survivor != null) {
            return ResponseEntity.ok("Survivor with ID " + id + " has been flagged as infected.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Survivor not found with ID " + id);
        }
    }
    @GetMapping("/infected")
    public ResponseEntity<List<Survivor>> getInfectedSurvivors() {
        List<Survivor> infectedSurvivors = survivorService.getInfectedSurvivors();
        return ResponseEntity.ok(infectedSurvivors);
    }
    @GetMapping("/non-infected")
    public ResponseEntity<List<Survivor>> getNonInfectedSurvivors() {
        List<Survivor> nonInfectedSurvivors = survivorService.getNonInfectedSurvivors();
        return ResponseEntity.ok(nonInfectedSurvivors);
    }

    @GetMapping("/infectedPercentage")
    public ResponseEntity<Double> getInfectedPercentage() {
        double infectedPercentage = survivorService.calculateInfectedPercentage();
        return ResponseEntity.ok(infectedPercentage);
    }

    @GetMapping("/nonInfectedPercentage")
    public ResponseEntity<Double> getNonInfectedPercentage() {
        double nonInfectedPercentage = 100 - survivorService.calculateInfectedPercentage();
        return ResponseEntity.ok(nonInfectedPercentage);
    }





}
