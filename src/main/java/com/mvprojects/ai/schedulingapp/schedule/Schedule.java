package com.mvprojects.ai.schedulingapp.schedule;

import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;

import java.time.LocalTime;
import java.util.List;

@PlanningSolution
public class Schedule {
    @PlanningEntityCollectionProperty
    List<Appointment> appointments;
    @ValueRangeProvider
    List<LocalTime> startTimes;
    @PlanningScore
    HardSoftScore score;

    public Schedule(){

    }

    public Schedule(List<Appointment> appointments, List<LocalTime> startTimes) {
        this.appointments = appointments;
        this.startTimes = startTimes;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<LocalTime> getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(List<LocalTime> startTimes) {
        this.startTimes = startTimes;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
