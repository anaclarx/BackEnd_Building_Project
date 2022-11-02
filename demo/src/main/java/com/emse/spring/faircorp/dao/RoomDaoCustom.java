package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDaoCustom {
    List<Window> findRoomWindows(@Param("id") Long id);
}
