package com.Survivor.app.Service.ServiceImpl;

import com.Survivor.app.Entity.Location;
import com.Survivor.app.Entity.Survivor;
import com.Survivor.app.Repository.SurvivorRepo;
import com.Survivor.app.Service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SurvivorServiceImpl implements SurvivorService {


    private final SurvivorRepo survivorRepo;
    @Autowired
    public SurvivorServiceImpl(SurvivorRepo survivorRepo) {
        this.survivorRepo = survivorRepo;
    }

    @Override
    public Survivor saveSurvivor(Survivor survivor) {
        return survivorRepo.save(survivor);
    }

    @Override
    public void updateSurvivorLocation(Long id, Location location) {
        // retrieve the data from the database
      Optional<Survivor> optionalSurvivor=survivorRepo.findById(id);
      // if the ID exist  or the record with that ID exist
        if (optionalSurvivor.isPresent()) {
            Survivor survivor = optionalSurvivor.get();
            // Update survivor's location
            Location currentLocation = survivor.getLastlocation();
            currentLocation.setLatitude(location.getLatitude());
            currentLocation.setLongitude(location.getLongitude());


            // Save updated survivor
            survivorRepo.save(survivor);
        } else {
            throw new IllegalArgumentException("Survivor with ID " + id + " not found.");
        }
    }

    @Override
    public List<Survivor> findAll() {
        return survivorRepo.findAll();
    }

    @Override
    public List<Survivor> findAllSurvivor() {
        return survivorRepo.findAll();
    }

    @Override
    public Optional<Survivor> findById(Long id) {
        return survivorRepo.findById(id);
    }

    @Override
    public Survivor flagSurvivorAsInfected(Long id) {
        Survivor survivor = survivorRepo.findById(id).orElse(null);
        if (survivor != null) {
            survivor.reportContamination();
            return survivorRepo.save(survivor);
        }
        return null;
    }

    @Override
    public List<Survivor> getInfectedSurvivors() {
        return survivorRepo.findByInfectedStatusTrue();
    }

    @Override
    public List<Survivor> getNonInfectedSurvivors() {
        return survivorRepo.findByInfectedStatusFalse();
    }

    @Override
    public double calculateInfectedPercentage() {
        List<Survivor> allSurvivors = survivorRepo.findAll();
        long infectedCount = allSurvivors.stream().filter(Survivor::isInfectedStatus).count();
        return (double) (infectedCount * 100) / allSurvivors.size();
    }


}
