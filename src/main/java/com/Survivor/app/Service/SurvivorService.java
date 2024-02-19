package com.Survivor.app.Service;

import com.Survivor.app.Entity.Location;
import com.Survivor.app.Entity.Survivor;

import java.util.List;
import java.util.Optional;

public interface SurvivorService {
    Survivor saveSurvivor(Survivor survivor);
    void updateSurvivorLocation(Long id, Location location);
    List<Survivor> findAll();

    List<Survivor> findAllSurvivor();

    Optional<Survivor> findById(Long id);

    Survivor flagSurvivorAsInfected(Long id);

    List<Survivor> getInfectedSurvivors();
    List<Survivor> getNonInfectedSurvivors();

    double calculateInfectedPercentage();

}
