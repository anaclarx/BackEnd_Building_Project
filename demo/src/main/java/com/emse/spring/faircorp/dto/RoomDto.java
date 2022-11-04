package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;

public class RoomDto {

    private Long id;
    private String name;
    private Double currentTemp;
    private Double targetTemp;
    private List<Heater> listOfHeaters;
    private List<Window> listOfWindows;
    private Long buildingId;
    private int floor;

    public RoomDto(){}

    public RoomDto (Room room){
        this.id = room.getId();
        this.name = room.getName();
        this.currentTemp= room.getCurrentTemp();
        this.targetTemp= room.getTargetTemp();
        this.buildingId=room.getBuilding().getId();
        this.floor= room.getFloor();
        this.listOfHeaters = room.getListOfHeaters();
        this.listOfWindows = room.getListOfWindows();
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Double getCurrentTemp() {return currentTemp;}

    public void setCurrentTemp(Double currentTemp) {this.currentTemp = currentTemp;}

    public Double getTargetTemp() {return targetTemp;}

    public void setTargetTemp(Double targetTemp) {this.targetTemp = targetTemp;}

    public Long getBuildingId() {return buildingId;}

    public void setBuildingId(Long buildingId) {this.buildingId = buildingId;}

    public int getFloor() {return floor;}

    public void setFloor(int floor) {this.floor = floor;}

    public List<Window> getListOfWindows(){return listOfWindows;}

    public void setListOfWindows(List<Window> listOfWindows){this.listOfWindows=listOfWindows;}

    public List<Heater> getListOfHeaters(){return listOfHeaters;}

    public void setListOfHeaters(List<Heater> listOfHeaters){this.listOfHeaters=listOfHeaters;}

}
