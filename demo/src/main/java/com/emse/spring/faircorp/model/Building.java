package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BUILDING")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @OneToMany(mappedBy = "building")
    private List<Room> listOfRooms;

    public Building(String name, List<Room> listOfRooms){
        this.name = name;
        this.listOfRooms = listOfRooms;
    }

    public Building(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Room> getRooms(){
        return listOfRooms;
    }

    public void setRooms(List<Room> listOfRooms){
        this.listOfRooms = listOfRooms;
    }
}