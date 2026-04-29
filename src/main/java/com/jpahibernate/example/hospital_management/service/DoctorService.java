package com.jpahibernate.example.hospital_management.service;

import com.jpahibernate.example.hospital_management.model.Doctor;
import com.jpahibernate.example.hospital_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;
import java.util.*;

@Service // it contains business logic
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully!";
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }

    public Doctor getDoctorById(int doctorId){
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        } else {
            return null;
        }
    }

    public String countDoctors(){
        long totalCount = doctorRepository.count();
        return "total doctors present are : "+totalCount;
    }

    public String deleteDoctorById(int id){
        doctorRepository.deleteById(id);
        return "Doctor with id : "+id+" is deleted successfully!";
    }

    //update using put operation - updates complete object
    public String updateDoctorUsingPut(int doctorId, Doctor newDoctorRequest){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = getDoctorById(doctorId);
        if(existingDoctor!=null){
            // proceed to update
            doctorRepository.save(newDoctorRequest);
            return "Doctor with id : "+doctorId+" updated successfully!";
        } else {
            // cannot update
            return "Doctor with id : "+doctorId+" cannot be updated as it is not present";
        }
    }

    //update using patch operation - single specific fields
    public String updateDoctorUsingPatch(int doctorId, String newMobile, String newEmail){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = getDoctorById(doctorId);
        if(existingDoctor!=null){
            // proceed to update
            existingDoctor.setMobile(newMobile);
            existingDoctor.setEmail(newEmail);
            doctorRepository.save(existingDoctor);
            return "Doctor with id : "+doctorId+" updated successfully!";
        } else {
            // cannot update
            return "Doctor with id : "+doctorId+" cannot be updated as it is not present";
        }
    }

}
