package com.emse.spring.faircop.dao;

import com.emse.spring.faircop.model.Heater;
import com.emse.spring.faircop.model.HeaterStatus;
import com.emse.spring.faircop.model.Room;
import com.emse.spring.faircop.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;
    @Autowired
    private RoomDao roomDao;

    @Test
    public void findHeater() {
        Heater heater = heaterDao.getById(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
    }

    @Test
    public void deleteByRoom() {
        Room room = roomDao.getById(-10L);
        List<Long> roomIds = room.getListOfWindows().stream().map(Window::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);
        heaterDao.deleteByRoom(-10L);
        List<Heater> heaters = heaterDao.findAllById(roomIds);
        Assertions.assertThat(heaters).isEmpty();
    }

}

