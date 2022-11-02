package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {

    @Query("select c from Window c where c.id=:id")
    Window getById(@Param("id") Long id);

    @Modifying
    @Query("delete from Window c where room_id =:room_id")
    void deleteByRoom(@Param("room_id") long room_id);

}
