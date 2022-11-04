package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "RWINDOW")
public class Window {
    // (3)
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Room room;


    // (4)
    @Column(nullable=false, length=255)
    private String name;

    // (5)
    @Column(nullable=false, length=255)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;

    public Window() {
    }

    public Window(String name, WindowStatus status, Room room, Long id) {
        this.windowStatus = status;
        this.name = name;
        this.room = room;
        this.id = id;
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom(){
        return room;
    }

    public void setRoom(Room room){
        this.room = room;
    }
}
