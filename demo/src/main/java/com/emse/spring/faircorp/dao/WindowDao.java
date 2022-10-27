package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long> {

    List<Window> getReferenceById(String referenceId);

    @Query("Select c from Window c where c.name=:name")
    Window findByName(@Param("name")String name);

    @Query("Select c.room.listOfWindows from Window c where c.windowStatus=OPEN")
    List<Window> findRoomOpenWindows(@Param("id")Long id);

    @Modifying
    @Query("delete * from Window c where c.room=:room")
    void deleteByName(String room);

}
