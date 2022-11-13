package com.emse.spring.faircop.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROOM")
public class Room {
    // (3)
    @Id
    @GeneratedValue
    private Long id;

    // (4)
    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private Integer floor;

    private Double currentTemp;

    private Double targetTemp;

    @OneToMany(mappedBy = "room")
    private List<Heater> listOfHeaters;

    @OneToMany(mappedBy = "room")
    private List<Window> listOfWindows;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Building building;



    public Room( Integer floor, String name,Building building) {
        this.floor = floor;
        this.name = name;
        this.building = building;
    }
    public Room(){}

    public Room(Integer floor, String name, Building building, Double currentTemp, Double targetTemp) {
        this.floor = floor;
        this.name = name;
        this.currentTemp = currentTemp;
        this.targetTemp = targetTemp;
        this.building = building;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setPower(Integer floor) {
        this.floor = floor;
    }

    public Double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public Double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(Double targetTempTemp) {
        this.targetTemp = currentTemp;
    }

    public List<Heater> getListOfHeaters() {
        return listOfHeaters;
    }

    public void setListOfHeaters(List<Heater> listOfHeaters) {
        this.listOfHeaters = listOfHeaters;
    }

    public List<Window> getListOfWindows() {
        return listOfWindows;
    }

    public void setListOfWindows(List<Window> listOfWindows) {
        this.listOfWindows = listOfWindows;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}