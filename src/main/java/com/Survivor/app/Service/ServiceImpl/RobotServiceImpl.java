package com.Survivor.app.Service.ServiceImpl;

import com.Survivor.app.Entity.Robot;
import com.Survivor.app.Service.RobotService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class RobotServiceImpl implements RobotService {

    private static final String ROBOT_CPU_URL = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";

    private final RestTemplate restTemplate;

    public RobotServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Robot> getAllRobots() {
        ResponseEntity<Robot[]> response = restTemplate.getForEntity(ROBOT_CPU_URL, Robot[].class);
        Robot[] robotsArray = response.getBody();
        List<Robot> robots = Arrays.asList(robotsArray);
        return robots;
    }
}
