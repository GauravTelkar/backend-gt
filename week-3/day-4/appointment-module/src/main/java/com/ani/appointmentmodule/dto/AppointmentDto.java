package com.ani.appointmentmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class AppointmentDto {
    private Long id;
    private String type;
    private LocalDate placed;
    private LocalDate appointment;
    private String doctorName;


}
