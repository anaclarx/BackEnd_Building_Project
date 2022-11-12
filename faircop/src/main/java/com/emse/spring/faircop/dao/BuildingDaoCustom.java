package com.emse.spring.faircop.dao;

import com.emse.spring.faircop.model.Heater;
import com.emse.spring.faircop.model.Window;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingDaoCustom {
    List<Window> findBuildingWindows(@Param("id") Long id);
    List<Heater> findBuildingHeaters(@Param("id") Long id);
}

