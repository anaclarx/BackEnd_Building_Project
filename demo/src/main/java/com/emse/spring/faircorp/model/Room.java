package com.emse.spring.faircorp.model;

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
    @Column(nullable=false, length=255)
    private String name;

    @Column(nullable=false, length=255)
    private Integer floor;

    private Double currentTemp;

    private Double targetTemp;

    @OneToMany(mappedBy = "room")
    private List<Heater> listOfHeaters;

    @OneToMany(mappedBy = "room")
    private List<Window> listOfWindows;

    public Room() {
    }

    public Room(String name, Integer floor, Double currentTemp, Double targetTemp, List<Heater> listOfHeaters, List<Window> listOfWindows) {
        this.name = name;
        this.floor = floor;
        this.currentTemp = currentTemp;
        this.targetTemp = targetTemp;
        this.listOfHeaters = listOfHeaters;
        this.listOfWindows = listOfWindows;
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

    public Integer getFloor(){
        return floor;
    }

    public void setPower(Integer floor){
        this.floor = floor;
    }

    public Double getCurrentTemp(){
        return currentTemp;
    }

    public void setCurrentTemp(Double currentTemp){
        this.currentTemp = currentTemp;
    }

    public Double getTargetTempTemp(){
        return targetTemp;
    }

    public void setTargetTempTemp(Double targetTempTemp){
        this.targetTemp = currentTemp;
    }

    public List<Heater> getListOfHeaters(){
        return listOfHeaters;
    }

    public void setListOfHeaters(List<Heater> listOfHeaters){
        this.listOfHeaters = listOfHeaters;
    }

    public List<Window> getListOfWindows(){
        return listOfWindows;
    }

    public void setListOfWindows(List<Window> listOfWindows){
        this.listOfWindows = listOfWindows;
    }
}