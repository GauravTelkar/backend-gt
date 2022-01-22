package com.ani.appointmentmodule.controller;

import com.ani.appointmentmodule.domain.Appointment;
import com.ani.appointmentmodule.dto.AppResponse;
import com.ani.appointmentmodule.dto.AppointmentBetweenDto;
import com.ani.appointmentmodule.dto.AppointmentDto;
import com.ani.appointmentmodule.exception.AppointementAlreadyExisting;
import com.ani.appointmentmodule.exception.DateOutOfBound;
import com.ani.appointmentmodule.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/appoint")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@Valid @RequestBody AppointmentDto dto) {
        var svObj = service.createAppointment(dto);

        var response = new AppResponse<AppointmentDto>();
        response.setStatus("success");
        response.setMessage("Abc saved successfully");
        response.setBody(svObj);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/SetAppoint")
    public ResponseEntity<AppResponse<LocalDate>> setAppointment(@Valid @RequestBody AppointmentDto dto) throws DateOutOfBound {
        try {
            LocalDate stat = service.setAppointment(dto.getId(), dto.getAppointment(), dto.getType());
            var response = new AppResponse<LocalDate>();
            response.setMessage("Appointment is set");
            response.setStatus("success");
            response.setBody(stat);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (DateOutOfBound e) {
            var response = new AppResponse<LocalDate>();
            response.setMessage(e.getMessage());
            response.setStatus("fail");
           // response.setBody("");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (AppointementAlreadyExisting e){
            var response = new AppResponse<LocalDate>();
            response.setMessage(e.getMessage());
            response.setStatus("fail");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/cancleAppoint")
    public ResponseEntity<AppResponse<String>> cancelAppointment(@Valid @RequestBody AppointmentDto dto) throws DateOutOfBound {
        String stat = service.cancelAppointment(dto.getId());
        var response = new AppResponse<String>();
        response.setMessage("Appointment is removed");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateAppoint")
    public ResponseEntity<AppResponse<String>> updateAppointment(@Valid @RequestBody AppointmentDto dto) {
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

    @GetMapping("/between")
    public ResponseEntity<AppResponse<List<AppointmentDto>>> findBetween(@RequestBody AppointmentBetweenDto dto){
        var response=new AppResponse<List<AppointmentDto>>();
        response.setStatus("success");
        response.setMessage("List of appointment ");
        response.setBody(service.getDaysBetweenDates(dto.getStart(),dto.getEnd()));
        return  ResponseEntity.ok(response);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> messages = new HashMap<>();

        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for(ObjectError oe : errors) {
            FieldError fe = (FieldError) oe;

            String errorField = fe.getField(); // it will tell. which is error filed
            String errorMessage = fe.getDefaultMessage(); // what is error message

            messages.put(errorField, errorMessage);
        }

        return messages;
    }
}
