package com.ani.appointmentmodule.service;

import com.ani.appointmentmodule.domain.Appointment;
import com.ani.appointmentmodule.dto.AppointmentDto;
import com.ani.appointmentmodule.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository repository;

    @Override
    public AppointmentDto createAppointment(AppointmentDto dto){

        var appoint = new Appointment();
        appoint.setType(dto.getType());
        appoint.setAppointment(dto.getAppointment());
        appoint.setPlaced(dto.getPlaced());
        appoint.setDoctorName(dto.getDoctorName());

        repository.save(appoint);
        return dto;
    }
    @Override
    public LocalDate setAppointment(Long id, LocalDate appointment,String type) {
        Optional<Appointment> op = repository.findById(id);
        Appointment baOld = op.orElseThrow();
        LocalDate existingAppointment = baOld.getAppointment();

        LocalDate today = LocalDate.from(LocalDateTime.now());
        int compareValue = today.compareTo(appointment);
        if (compareValue > 0) {

            String existingType = baOld.getType();
            LocalDate newAppointment = appointment;
            String newType = type;
            Appointment baNew = new Appointment();
            baNew.setAppointment(appointment);
            baNew.setId(baOld.getId());
            baNew.setType(newType);
            baNew.setPlaced(baOld.getPlaced());
            baNew.setDoctorName(baOld.getDoctorName());

            repository.save(baNew);

            return baNew.getAppointment();
        }
        return today;
    }
    @Override
    public String cancelAppointment(Long id,String type){
        Optional<Appointment> op = repository.findById(id);
        Appointment baOld = op.orElseThrow();
        String existingType = baOld.getType();
        String newType= type;
        Appointment baNew = new Appointment();
        baNew.setAppointment(baOld.getAppointment());
        baNew.setId(baOld.getId());
        baNew.setType(newType);
        baNew.setPlaced(baOld.getPlaced());
        baNew.setDoctorName(baOld.getDoctorName());

        repository.save(baNew);

        return baNew.getType();
    }

    @Override
    public String updateAppointment(Long id,String type){
        Optional<Appointment> op = repository.findById(id);
        Appointment baOld = op.orElseThrow();
        String existingType = baOld.getType();
        String newType= type;
        Appointment baNew = new Appointment();
        baNew.setAppointment(baOld.getAppointment());
        baNew.setId(baOld.getId());
        baNew.setType(newType);
        baNew.setPlaced(baOld.getPlaced());
        baNew.setDoctorName(baOld.getDoctorName());

        repository.save(baNew);

        return baNew.getType();
    }

    @Override
    public List<Appointment> findAllApp() {
        return repository.findAll();
    }

    @Override
    public List<AppointmentDto> getDaysBetweenDates(LocalDate start, LocalDate end){
        List<Appointment> app=repository.findByAppointmentBetween(start,end);
        List<AppointmentDto> appdto = new ArrayList<>();
        for(int i=0;i<app.size();i++)
        {
            Appointment apps= app.get(i);
            AppointmentDto dto=new AppointmentDto(
                    apps.getId(),
                    apps.getType(),
                    apps.getPlaced(),
                    apps.getAppointment(),
                    apps.getDoctorName()

            );
            appdto.add(dto);
        }
        return appdto;
    }
}
