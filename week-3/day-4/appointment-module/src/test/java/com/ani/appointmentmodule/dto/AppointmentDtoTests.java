package com.ani.appointmentmodule.dto;

import com.ani.appointmentmodule.domain.Appointment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AppointmentDtoTests {
    @DisplayName("Dto : Checking Object Creation")
    @Test
    void testObjectCreation() {
        LocalDate dt=LocalDate.now();
        LocalDate dt2=LocalDate.now();
        var abc = new AppointmentDto(1l,"gg",dt,dt2,"hhh");
        Assertions.assertNotNull(abc);
    }

    @DisplayName("Dto : Checking Values")
    @Test
    void testObjectCreation2() {
        LocalDate dt=LocalDate.now();
        LocalDate dt2=LocalDate.now();
        var abc = new AppointmentDto(1l,"gg",dt,dt2,"hhh");
        Assertions.assertEquals(1,abc.getId());
        Assertions.assertEquals("gg",abc.getType());
        Assertions.assertEquals((LocalDate.now()) ,abc.getPlaced());
        Assertions.assertEquals((LocalDate.now()),abc.getAppointment());
        Assertions.assertEquals("hhh",abc.getDoctorName());
    }
}
