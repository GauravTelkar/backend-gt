package com.ani.appointmentmodule.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AppointmentBetweenDtoTests {
    @DisplayName("Dto : Checking Object Creation")
    @Test
    void testObjectCreation() {
        LocalDate dt=LocalDate.now();
        LocalDate dt2=LocalDate.now();
        var abc = new AppointmentBetweenDto(dt,dt2);
        Assertions.assertNotNull(abc);
    }
    @DisplayName("Dto : Checking Values")
    @Test
    void testObjectCreation2() {
        LocalDate dt=LocalDate.now();
        LocalDate dt2=LocalDate.now();
        var abc = new AppointmentBetweenDto(dt,dt2);
        Assertions.assertEquals((LocalDate.now()) ,abc.getStart());
        Assertions.assertEquals((LocalDate.now()),abc.getEnd());
    }
}
