package com.emse.spring.faircop.dto;

import com.emse.spring.faircop.model.Heater;
import com.emse.spring.faircop.model.HeaterStatus;

public class HeaterDto {
    private Long id;
    private String name;
    private Long roomId;

    private Long heaterPower;
    private HeaterStatus heaterStatus;

    public HeaterDto(){

    }
    public HeaterDto(Heater heater){
        this.id=heater.getId();
        this.name=heater.getName();
        this.heaterStatus=heater.getHeaterStatus();
        this.heaterPower = heater.getPower();
        this.roomId=heater.getRoom().getId();
    }





    //Getters and setters
    public Long getId() {
        return id;
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

    public Long getRoom() {
        return roomId;
    }

    public void setRoom(Long id) {
        this.roomId = id;
    }

    public Long getHeaterPower(){
        return heaterPower;
    }

    public void setHeaterPower(){
        this.heaterPower = heaterPower;
    }

    public HeaterStatus getHeater_status() {
        return heaterStatus;
    }

    public void setHeater_status(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}