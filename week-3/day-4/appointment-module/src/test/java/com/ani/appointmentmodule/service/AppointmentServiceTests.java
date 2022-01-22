package com.ani.appointmentmodule.service;

import com.ani.appointmentmodule.domain.Appointment;
import com.ani.appointmentmodule.repository.AppointmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class AppointmentServiceTests {

    @Mock
    private AppointmentRepository repository;

    @InjectMocks
    private AppointmentService service;

    @Test
    public void testDateBetween(){
        var st = LocalDate.of(2021,1,1);
        var ed = LocalDate.of(2023,1,1);

        var ap1 = new Appointment();
        ap1.setId(12L);
        ap1.setType("abc");
        ap1.setAppointment(LocalDate.now());
        ap1.setPlaced(LocalDate.now());
        ap1.setDoctorName("asaa");


        var ap2 = new Appointment();
        ap2.setId(14L);
        ap2.setType("pqr");
        ap2.setAppointment(LocalDate.now());
        ap2.setPlaced(LocalDate.now());
        ap2.setDoctorName("aaa");

        Mockito.when(
                service.getDaysBetweenDates(st,ed)
        ).thenReturn(
                List.of(
                        ap1,
                        ap2
                )
        );

        var apps = service.getDaysBetweenDates(st, ed); // you called the function 1 time
        Assertions.assertEquals(apps.size(), 2);

        Mockito.verify(
                repository,
                Mockito.times(1)
        ).findByAppointmentBetween(st, ed);

    }
}
