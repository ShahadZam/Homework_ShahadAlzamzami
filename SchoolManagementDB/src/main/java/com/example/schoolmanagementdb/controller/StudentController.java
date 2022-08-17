package com.example.schoolmanagementdb.controller;


import com.example.schoolmanagementdb.dto.ApiResponse;
import com.example.schoolmanagementdb.model.Student;
import com.example.schoolmanagementdb.model.Teacher;
import com.example.schoolmanagementdb.service.StudentService;
import com.example.schoolmanagementdb.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List> getUStudents(){
        List<Student> students= studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }



    @PostMapping
    public ResponseEntity<ApiResponse> addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new ApiResponse("New student added !",201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateStudent(@RequestBody @Valid Student student, @PathVariable Long id){
        studentService.updateStudent(student,id);
        return ResponseEntity.status(201).body(new ApiResponse("student data updated !",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(201).body(new ApiResponse("student deleted !",201));
    }

    @GetMapping("/ids")
    public ResponseEntity<Student> getStudentByID(@RequestBody Long id){
        Student student= studentService.findStudentById(id);
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/byNames")
    public ResponseEntity<Student> getStudentByName(@RequestBody String name){
        Student student= studentService.findStudentName(name);
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping("/byMajors")
    public ResponseEntity<List> getStudentsByMajor(@RequestBody String major){
        List<Student> students= studentService.findStudentMajor(major);
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/byAge")
    public ResponseEntity<List> getStudentsByAge(@RequestBody Integer age){
        List<Student> students= studentService.findStudentAge(age);
        return ResponseEntity.status(200).body(students);
    }







}
