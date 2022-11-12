package com.emse.spring.faircop.dao;

import com.emse.spring.faircop.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HeaterDao extends JpaRepository<Heater, Long> {

    @Query("Select c from Heater c where c.id=:id")
    Heater getById(@Param("id")Long id);

    @Modifying
    @Query("delete from Heater c where room_id=:room_id")
    void deleteByRoom(Long room_id);

}
