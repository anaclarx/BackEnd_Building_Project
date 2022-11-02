package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RoomDao {
    @Query("select c from Room c where c.id=:id")
    Room getById(@Param("id") Long id);

}
