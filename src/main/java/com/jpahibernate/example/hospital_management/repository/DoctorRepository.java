package com.jpahibernate.example.hospital_management.repository;

import com.jpahibernate.example.hospital_management.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //it performs the database operations
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
