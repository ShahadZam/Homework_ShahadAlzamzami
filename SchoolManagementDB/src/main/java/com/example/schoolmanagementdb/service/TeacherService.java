package com.example.schoolmanagementdb.service;

import com.example.schoolmanagementdb.exception.ApiException;
import com.example.schoolmanagementdb.model.Teacher;
import com.example.schoolmanagementdb.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    public final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher, Long id) {
        Teacher teacher1 = teacherRepository.getById(id);
        // teacher1.setId(teacher.getId());
        teacher1.setName(teacher.getName());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.getById(id);
        teacherRepository.delete(teacher);
    }

    public Teacher findTeacher(Long id) {
        Teacher teacher = teacherRepository.getById(id);
        if (teacher==null){
            throw new ApiException("There is no teacher with this id!");
        }
        return teacher;
    }

    public List<Teacher> getTeachersBySalary(Integer salary) {
        List<Teacher> teachers= teacherRepository.findBySalaryGreaterThanEqual(salary);
        if (teachers.isEmpty()){
            throw new ApiException("There is no teachers with salary or more!");
        }
        return teachers;
    }


}
