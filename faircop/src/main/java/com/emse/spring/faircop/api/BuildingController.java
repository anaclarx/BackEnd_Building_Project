package com.emse.spring.faircop.api;

import com.emse.spring.faircop.dao.BuildingDao;
import com.emse.spring.faircop.dto.BuildingDto;
import com.emse.spring.faircop.dto.HeaterDto;
import com.emse.spring.faircop.dto.WindowDto;
import com.emse.spring.faircop.model.Building;
import com.emse.spring.faircop.model.Heater;
import com.emse.spring.faircop.model.Window;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(" /api/buildings")
@Transactional
public class BuildingController {

    private final BuildingDao buildingDao;

    public BuildingController(BuildingDao buildingDao){this.buildingDao=buildingDao;}

    @GetMapping
    public List<BuildingDto> findAll(){
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id){
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id){
        buildingDao.deleteById(id);
    }
    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto){
        Building building = null;
        building = buildingDao.save(new Building(dto.getName()));
        return new BuildingDto(building);
    }

    @GetMapping(path = " /{id}/windows")
    public List<WindowDto> findBuildingWindows(@PathVariable Long id){
        List<Window> windows=buildingDao.findBuildingWindows(id);
        return windows.stream().map(WindowDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = " /{id}/heaters")
    public List<HeaterDto> findBuildingHeaters(@PathVariable Long id){
        List<Heater> heaters=buildingDao.findBuildingHeaters(id);
        return heaters.stream().map(HeaterDto::new).collect(Collectors.toList());
    }

}
