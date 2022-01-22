package com.ani.appointmentmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppointmentBetweenDto {
    private LocalDate start;
    private  LocalDate end;
}
