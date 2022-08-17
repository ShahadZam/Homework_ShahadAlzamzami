package com.example.schoolmanagementdb.repository;


import com.example.schoolmanagementdb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    Student findStudentByName(String name);

    List<Student> findStudentsByMajor(String major);

    List<Student> findStudentsByAgeIsGreaterThanEqual (Integer age);

}
