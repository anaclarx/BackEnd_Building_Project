package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "HEATER")
public class Heater {
    // (3)
    @Id
    @GeneratedValue
    private Long id;

    // (4)
    @Column(nullable=false, length=255)
    private String name;

    @Column(nullable=false, length=255)
    private Long power;

    @ManyToOne(optional = false)
    private Room room;

    // (5)
    @Column(nullable=false, length=255)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    public Heater() {
    }

    public Heater(String name, Long power, Room room, HeaterStatus status) {
        this.name = name;
        this.power = power;
        this.room = room;
        this.heaterStatus = status;
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

    public Long getPower(){
        return power;
    }

    public void setPower(Long power){
        this.power = power;
    }

    public Room getRoom(){
        return room;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public HeaterStatus getWindowStatus() {
        return heaterStatus;
    }

    public void setWindowStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
