package com.emse.spring.faircop.dao;

import com.emse.spring.faircop.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomDao  extends JpaRepository<Room, Long>, RoomDaoCustom  {
    @Query("select c from Room c where c.id=:id")
    Room getById(@Param("id") Long id);

}
