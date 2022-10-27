package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeaterDao {

    List<Heater> findBySiteId(String siteId);

    @Query("Select c from Heater c where c.name=:name")
    Heater findByName(@Param("name")String name);

    @Modifying
    @Query("delete * from Heater c where c.room=:room")
    void deleteByName(String room);

}
