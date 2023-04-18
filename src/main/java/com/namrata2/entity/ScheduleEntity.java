package com.namrata2.entity;


import jakarta.persistence.*;

/**
 * Entity that represents schedule data
 *
 * @author Namrata
 */

@Entity
@Table
public class ScheduleEntity {

    @Id
    @Column(name="id")
    private String id;
    @Column(name = "line")
    private String line;

    @Column(name = "departure")
    private String departure;

    @Column(name = "arrival")
    private String arrival;

    public ScheduleEntity() {

    }

    public ScheduleEntity(final String id, final String line, final String departure, final String arrival) {
        this.id = id;
        this.line = line;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Schedule [id=" + id + ", line=" + line + ", departure=" + departure + ", arrival=" + arrival + "]";
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }


}
