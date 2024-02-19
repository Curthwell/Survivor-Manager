package com.Survivor.app.Controller;

import com.Survivor.app.Entity.Robot;
import com.Survivor.app.Service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
@RequestMapping("/robots")
public class RobotController {
    private final RobotService robotService;

    @Autowired
    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @GetMapping
    public ResponseEntity<Flux<Robot>> getAllRobots() {
        Flux<Robot> robots = robotService.getAllRobots();
        return ResponseEntity.ok(robots);
    }
}
