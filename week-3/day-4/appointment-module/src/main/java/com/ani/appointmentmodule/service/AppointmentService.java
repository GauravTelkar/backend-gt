package com.ani.appointmentmodule.service;

import com.ani.appointmentmodule.domain.Appointment;
import com.ani.appointmentmodule.dto.AppointmentDto;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    public AppointmentDto createAppointment(AppointmentDto dto);

    LocalDate setAppointment(Long id, LocalDate appointment,String type);

    String cancelAppointment(Long id,String type);

    String updateAppointment(Long id,String type);

    List<Appointment> findAllApp();

    List<AppointmentDto> getDaysBetweenDates(LocalDate startdate, LocalDate enddate);


}
