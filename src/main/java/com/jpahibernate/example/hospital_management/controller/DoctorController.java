package com.jpahibernate.example.hospital_management.controller;


import com.jpahibernate.example.hospital_management.model.Doctor;
import com.jpahibernate.example.hospital_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.*;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    // ui -> request -> controller api -> service -> repository
    // response -> repository -> service -> controller api -> ui(postman)

    // debugging - tracing the flow of the application(understanding line by line what is happening and all)

    //spring boot application - takes input in the form of JSON(javascript object notation)

    // @RequestBody - it is used to take input request from UI or postman and it is used for only complete class inputs

    @Autowired
    DoctorService doctorService;

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor){
        String response = doctorService.saveDoctor(doctor);
        return response;
    }

    // @PathVariable - it is used to take input in the url path
    @GetMapping("/findById/{id}")
    public Doctor findDoctorById(@PathVariable int id){
        Doctor doctor = doctorService.getDoctorById(id);
        return doctor;
    }

    @GetMapping("/findAll")
    public List<Doctor> findAllDoctor(){
        List<Doctor> doctorList = doctorService.getAllDoctors();
        return doctorList;
    }

    @GetMapping("/count")
    public String countDoctors(){
        String response = doctorService.countDoctors();
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctorById(@PathVariable int id){
        String response = doctorService.deleteDoctorById(id);
        return response;
    }
}
