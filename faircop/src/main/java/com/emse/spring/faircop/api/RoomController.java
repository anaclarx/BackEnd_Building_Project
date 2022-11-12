package com.emse.spring.faircop.api;

import com.emse.spring.faircop.dao.BuildingDao;
import com.emse.spring.faircop.dao.RoomDao;
import com.emse.spring.faircop.dto.RoomDto;
import com.emse.spring.faircop.dto.WindowDto;
import com.emse.spring.faircop.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {

    private final RoomDao roomDao;
    private final BuildingDao buildingDao;

    public RoomController(RoomDao roomDao, BuildingDao buildingDao){
        this.roomDao = roomDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<RoomDto> findAll(){
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id){
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @DeleteMapping(path = " /{id}")
    public void delete(@PathVariable Long id){
        roomDao.deleteById(id);
    }
    @PutMapping(path = "/{id}/switchWindow")
    public RoomDto switchWindow(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Window window:room.getListOfWindows())
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);

        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/switchHeater")
    public RoomDto switchHeater(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        for (Heater heater:room.getListOfHeaters())
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);

        return new RoomDto(room);
    }

    //Create room
    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {

        Room room = null;
        Building building = buildingDao.getReferenceById(dto.getBuildingId());
        room = roomDao.save(new Room(dto.getName(), dto.getFloor(), dto.getCurrentTemp(), dto.getTargetTemp(),building, dto.getListOfHeaters(), dto.getListOfWindows()));

        return new RoomDto(room);
    }

    //Update a room target temperature
    @PutMapping(path = "/{id}")
    public RoomDto updateTargetTemperature(@PathVariable Long id, @RequestBody RoomDto dto) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        room.setTargetTemp(dto.getTargetTemp());

        return new RoomDto(room);
    }

    //find rooms in a building identified with its id
    @GetMapping(path="/{id}/windows")
    public List<WindowDto> findRoomWindows(@PathVariable Long id) {
        List<Window> windows= roomDao.findRoomWindows(id);
        return windows.stream().map(WindowDto::new).collect(Collectors.toList());
    }

}
