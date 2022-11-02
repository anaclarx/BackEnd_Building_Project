package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.emse.spring.faircorp.model.Heater;

public interface BuildingDaoCustom {
    List<Window> findBuildingWindows(@Param("id") Long id);
    List<Heater> findBuildingHeaters(@Param("id") Long id);
}
