package com.namrata2.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.namrata2.model.ScheduleModel;
import com.namrata2.service.ScheduleService;
import com.namrata2.util.TimeValidatorAndConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ScheduleController {


    @Autowired
    ScheduleService scheduleService;

    /**
     * This API returns the entire timetable as a JSON array.
     *
     * Empty schedule array return 204 No Content
     * Any errors will be propagated as 500 Internal Server Error
     * @return
     */
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

    /**
     * This endpoint will serve two cases,
     *  - If departure param is null or not passed or is invalid then it returns all schedules for a particular line.
     *  - If valid departure param is passed on, then it serves to return the result by line and departure.
     * @param line
     * @param departure
     * @return
     */
    @GetMapping("/schedule/{line}")
    public ResponseEntity<List<ScheduleModel>> getScheduleByLine(@PathVariable("line") String line, @RequestParam(required = false) String departure) {
        try {

            final List<ScheduleModel> allSchedules = scheduleService.getScheduleByLine(line);

            if (allSchedules.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            List<ScheduleModel> schedulesByDeparture = new ArrayList<ScheduleModel>();
            if (departure != null) {
                var convertedDeparture = validateAndConvertDepartureTime(departure);
                schedulesByDeparture = allSchedules.stream().filter(s -> convertedDeparture.equals(s.getDeparture())).toList();
                return new ResponseEntity<>(schedulesByDeparture, HttpStatus.OK);
            }
            return new ResponseEntity<>(allSchedules, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static String validateAndConvertDepartureTime(final String s) throws ParseException {
        var is12HrFormat = TimeValidatorAndConverter.checkIf12HrFormat(s);
        if (is12HrFormat) {
            String s1 = TimeValidatorAndConverter.convert12HrTo24HrFormat(s);
            return s1;
        }
        var is24HrFormat = TimeValidatorAndConverter.checkIf24HrFormat(s);
        if (is24HrFormat) {
            return s;
        }

       throw new IllegalArgumentException();
    }
}
