package com.namrata2.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.namrata2.entity.ScheduleEntity;
import com.namrata2.mapper.ScheduleMapper;
import com.namrata2.model.ScheduleModel;
import com.namrata2.store.ScheduleStore;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class ScheduleService {

    private List<ScheduleModel> schedulesList = new ArrayList<>();
    @Autowired
    private ScheduleStore scheduleStore;
    @Autowired
    private ScheduleMapper scheduleMapper;


    @PostConstruct
    void init() throws IOException {
        schedulesList = loadSchedules();
        saveSchedules();
        System.out.println("Size:    ..........." + schedulesList.size());
    }


    private List<ScheduleModel> loadSchedules() throws IOException {
        try (var schedule = new ClassPathResource("/schedules.json").getInputStream()) {
            return Arrays.asList(new ObjectMapper().readValue(schedule, ScheduleModel[].class));
        }
    }

    private void saveSchedules() {
        scheduleStore.saveAll(scheduleMapper.mapScheduleModelsToScheduleEntities(schedulesList));
    }

    public List<ScheduleModel> getAllSchedules() throws Exception {
        var scheduleEntities=new ArrayList<ScheduleEntity>();
        scheduleStore.findAll().forEach(scheduleEntities::add);
        var scheduleModels = scheduleMapper.mapScheduleEntitiesToScheduleModels(scheduleEntities);
        return new ArrayList<>(scheduleModels);
    }

    public List<ScheduleModel> getScheduleByLine(final String line)
    {
        var scheduleEntities = scheduleStore.findByLine(line);
        var scheduleModels = scheduleMapper.mapScheduleEntitiesToScheduleModels(scheduleEntities);
        return new ArrayList<>(scheduleModels);
    }

}
