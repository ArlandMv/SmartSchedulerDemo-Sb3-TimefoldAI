package com.mvprojects.ai.schedulingapp.schedule;

import ai.timefold.solver.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class ScheduleController {
    @Autowired
    SolverManager<Schedule, String> solverManager;
    @GetMapping("/")
    public Schedule schedule() throws ExecutionException, InterruptedException {
        var problem = new Schedule(
                List.of(
                        new Appointment(
                                "Client Meeting",
                                Duration.ofHours(2)
                        ),
                        new Appointment(
                                "Review",
                                Duration.ofHours(1)
                        ),
                        new Appointment(
                                "Development ",
                                Duration.ofHours(3)
                        )
                ),
                List.of(
                        LocalTime.of(9,0),
                        LocalTime.of(12,0),
                        LocalTime.of(14,0),
                        LocalTime.of(17,0)
                        )
        );
        return solverManager.solve("job 1", problem).getFinalBestSolution();
    }
}
