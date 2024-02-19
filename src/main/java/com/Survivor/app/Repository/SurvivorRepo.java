package com.Survivor.app.Repository;

import com.Survivor.app.Entity.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurvivorRepo extends JpaRepository<Survivor,Long> {
    List<Survivor> findByInfectedStatusTrue();
    List<Survivor> findByInfectedStatusFalse();
}
