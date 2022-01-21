package com.ani.appointmentmodule.controller;

import com.ani.appointmentmodule.domain.Appointment;
import com.ani.appointmentmodule.dto.AppResponse;
import com.ani.appointmentmodule.dto.AppointmentBetweenDto;
import com.ani.appointmentmodule.dto.AppointmentDto;
import com.ani.appointmentmodule.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequestMapping("/appoint")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@RequestBody AppointmentDto dto) {
        var svObj = service.createAppointment(dto);

        var response = new AppResponse<AppointmentDto>();
        response.setStatus("success");
        response.setMessage("Abc saved successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/SetAppoint")
    public ResponseEntity<AppResponse<LocalDate>> setAppointment(@RequestBody AppointmentDto dto) {
        LocalDate stat = service.setAppointment(dto.getId(),dto.getAppointment(), dto.getType());
        var response = new AppResponse<LocalDate>();
        response.setMessage("Appointment is set");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/cancleAppoint")
    public ResponseEntity<AppResponse<String>> cancelAppointment(@RequestBody AppointmentDto dto) {
        String stat = service.cancelAppointment(dto.getId(), dto.getType());
        var response = new AppResponse<String>();
        response.setMessage("Appointment is removed");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateAppoint")
    public ResponseEntity<AppResponse<String>> updateAppointment(@RequestBody AppointmentDto dto) {
        String stat = service.updateAppointment(dto.getId(), dto.getType());
        var response = new AppResponse<String>();
        response.setMessage("Appointment is removed");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/show")
    public List<Appointment> findAllAppointment() {
        return service.findAllApp();
    }

    @GetMapping("/all")
    public ResponseEntity<AppResponse<List<AppointmentDto>>> findbetween(@RequestBody AppointmentBetweenDto dto){
        var response=new AppResponse<List<AppointmentDto>>();
        response.setStatus("success");
        response.setMessage("List of appointment ");
        response.setBody(service.getDaysBetweenDates(dto.getStart(),dto.getEnd()));
        return  ResponseEntity.ok(response);
    }
}
