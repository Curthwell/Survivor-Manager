package com.Survivor.app.Service.ServiceImpl;

import com.Survivor.app.Entity.Robot;
import com.Survivor.app.Service.RobotService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@Service
public class RobotServiceImpl implements RobotService {
    private static final String ROBOT_CPU_URL ="https://robotstakeover20210903110417.azurewebsites.net/robotcpu" ;
    private final WebClient webClient;

    public RobotServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(ROBOT_CPU_URL).build();
    }


    @Override
    public Flux<Robot> getAllRobots() {
        return webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Robot.class);
    }
}

