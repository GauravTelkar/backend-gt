package com.ani.appointmentmodule.repository;

import com.ani.appointmentmodule.domain.Appointment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppointmentRepositoryTests {
    @Autowired
    private AppointmentRepository repository;

    @DisplayName("Appointment repo : creating ")
    @Test
    public void testCreateAppointment(){
        var app = new Appointment();
        app.setId(15L);
        app.setType("ipd");
        app.setAppointment(LocalDate.now());
        app.setDoctorName("abc");
        app.setPlaced(LocalDate.now());

        repository.save(app);
    }
}
