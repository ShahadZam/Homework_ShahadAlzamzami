package com.example.schoolmanagementdb.controller;

import com.example.schoolmanagementdb.dto.ApiResponse;
import com.example.schoolmanagementdb.model.Teacher;
import com.example.schoolmanagementdb.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List> getTeachers(){
        List<Teacher> teachers= teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }



    @PostMapping
    public ResponseEntity<ApiResponse> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new ApiResponse("New teacher added !",201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateTeacher(@RequestBody @Valid Teacher teacher,@PathVariable Long id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(201).body(new ApiResponse("teacher data updated !",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(201).body(new ApiResponse("teacher deleted !",201));
    }

    @GetMapping("/ids")
    public ResponseEntity<Teacher> getTeacherByID(@RequestBody Long id){
        Teacher teacher= teacherService.findTeacher(id);
        return ResponseEntity.status(200).body(teacher);
    }

    @GetMapping("/salary")
    public ResponseEntity<List<Teacher>> getTeacherBySalary(@RequestBody  Integer salary){
        List<Teacher> teachers= teacherService.teacherRepository.findBySalaryGreaterThanEqual(salary);
        return ResponseEntity.status(200).body(teachers);
    }
}
