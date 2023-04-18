package com.namrata2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.namrata.model.Student;
import com.namrata2.model.ScheduleModel;
import com.namrata2.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //    @GetMapping("/schedule/{line}")
//    public ResponseEntity<List<ScheduleModel>> getScheduleByLine(@PathVariable("line") String line)
//    {
//        try {
//            final List<ScheduleModel> allSchedules = scheduleService.getScheduleByLine(line);
//
//            if (allSchedules.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//
//            return new ResponseEntity<>(allSchedules, HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping("/schedule/{line}")
    public ResponseEntity<List<ScheduleModel>> getScheduleByLine(@PathVariable("line") String line, @RequestParam(required = false) String departure) {
        try {

            final List<ScheduleModel> allSchedules = scheduleService.getScheduleByLine(line);

            if (allSchedules.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<ScheduleModel> schedulesByDeparture = new ArrayList<ScheduleModel>();
            if (departure != null) {
                System.out.println("DEPARTURE PRESENT.......................");
                schedulesByDeparture = allSchedules.stream().filter(s -> departure.equals(s.getDeparture())).toList();
                return new ResponseEntity<>(schedulesByDeparture,HttpStatus.OK);
            }
            return new ResponseEntity<>(allSchedules, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
