package com.emse.spring.faircop.dao;

import com.emse.spring.faircop.model.Window;
import com.emse.spring.faircop.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class WindowDaoTest {

    @Autowired
    private WindowDao windowDao;

    @Autowired
    private RoomDao roomDao;

    @Test
    public void findWindow(){
        Window window = windowDao.getById(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);

    }

    @Test
    public void dontFindOpenWindow() {
        List<Window> result = windowDao.findByOpenWindow(-10L);
        Assertions.assertThat(result).isEmpty();
    }

}
