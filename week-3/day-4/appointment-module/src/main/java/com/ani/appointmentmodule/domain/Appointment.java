package com.ani.appointmentmodule.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false, nullable = false)
    private String type;

    @Column(unique = false, nullable = false)
    private LocalDate placed;

    @Column(unique = false, nullable = false)
    private LocalDate appointment;

    @Column(unique = true, nullable = true)
    private String doctorName;


}
