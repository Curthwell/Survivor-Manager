package com.Survivor.app.Service;

import com.Survivor.app.Entity.Robot;
import reactor.core.publisher.Flux;

import java.util.List;

public interface RobotService {
    Flux<Robot> getAllRobots();
}
