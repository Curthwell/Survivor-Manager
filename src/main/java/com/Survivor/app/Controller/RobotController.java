package com.Survivor.app.Controller;

import com.Survivor.app.Entity.Robot;
import com.Survivor.app.Service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public List<Robot> getAllRobots() {
        return robotService.getAllRobots();
    }
}
