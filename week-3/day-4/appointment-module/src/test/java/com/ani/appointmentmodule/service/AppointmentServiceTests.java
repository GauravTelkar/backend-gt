package com.ani.appointmentmodule.service;

import com.ani.appointmentmodule.domain.Appointment;
import com.ani.appointmentmodule.dto.AppointmentDto;
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
    private AppointmentServiceImpl service;

  /*  @Test
    public void testDateBetween(){
        var st = LocalDate.of(2020,1,1);
        var ed = LocalDate.of(2026,1,1);

        var ap3 = new Appointment();
        ap3.setId(12L);
        ap3.setType("abc");
        ap3.setAppointment(LocalDate.now());
        ap3.setPlaced(LocalDate.now());
        ap3.setDoctorName("asaa");

        var ap4 = new Appointment();
        ap4.setId(12L);
        ap4.setType("abc");
        ap4.setAppointment(LocalDate.now());
        ap4.setPlaced(LocalDate.now());
        ap4.setDoctorName("asaa");

        var ap1 = new AppointmentDto();
        ap1.setId(12L);
        ap1.setType("abc");
        ap1.setAppointment(LocalDate.now());
        ap1.setPlaced(LocalDate.now());
        ap1.setDoctorName("asaa");


        var ap2 = new AppointmentDto();
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

        var apps = service.getDaysBetweenDates(st, ed);
        Assertions.assertEquals( 2,apps.size());

  /*        Mockito.verify(
              repository,
                Mockito.times(1)
        ).findByAppointmentBetween(st, ed);

    } */
}
