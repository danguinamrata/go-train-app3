package com.namrata2.controller;

import java.util.List;

import com.namrata2.model.ScheduleModel;
import com.namrata2.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namrata2.entity.ScheduleEntity;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ScheduleController {


    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleModel>> getAllSchedules() {
        try {
            final List<ScheduleModel> allSchedules = scheduleService.getAllSchedules();

            if (allSchedules.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(allSchedules, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
