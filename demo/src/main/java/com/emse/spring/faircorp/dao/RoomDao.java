package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RoomDao  extends JpaRepository<Room, Long>, RoomDaoCustom  {
    @Query("select c from Room c where c.id=:id")
    Room getById(@Param("id") Long id);

}
