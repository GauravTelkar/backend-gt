package com.ani.appointmentmodule.service;

import com.ani.appointmentmodule.domain.Appointment;
import com.ani.appointmentmodule.dto.AppointmentDto;
import com.ani.appointmentmodule.exception.AppointementAlreadyExisting;
import com.ani.appointmentmodule.exception.DateOutOfBound;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    public AppointmentDto createAppointment(AppointmentDto dto);

    LocalDate setAppointment(Long id, LocalDate appointment,String type) throws DateOutOfBound, AppointementAlreadyExisting;

    String cancelAppointment(Long id);

    String updateAppointment(Long id,String type);

    List<Appointment> findAllApp();

    List<AppointmentDto> getDaysBetweenDates(LocalDate startdate, LocalDate enddate);


}
