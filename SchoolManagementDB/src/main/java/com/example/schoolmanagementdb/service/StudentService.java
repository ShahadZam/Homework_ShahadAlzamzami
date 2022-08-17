package com.example.schoolmanagementdb.service;

import com.example.schoolmanagementdb.exception.ApiException;
import com.example.schoolmanagementdb.model.Student;
import com.example.schoolmanagementdb.model.Teacher;
import com.example.schoolmanagementdb.repository.StudentRepository;
import com.example.schoolmanagementdb.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    public final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student, Long id) {
        Student student1=studentRepository.getById(id);
        // student1.setId(student.getId());
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
        studentRepository.save(student1);
    }

    public void deleteStudent(Long id) {
        Student student=studentRepository.getById(id);
        studentRepository.delete(student);
    }

    public Student findStudentById(Long id) {
        Student student=studentRepository.getById(id);
        if(student==null){
            throw new ApiException("There is no student with this ID!");
        }
        return student;

    }

    public Student findStudentName(String name) {
        return studentRepository.findStudentByName(name);
    }

    public List<Student> findStudentMajor(String major) {
        List<Student> students=studentRepository.findStudentsByMajor(major);
        if (students.isEmpty()){
            throw new ApiException("There is no students with this major!");

        }
        return students;

    }

    public List<Student> findStudentAge(Integer age) {
        List<Student> students=studentRepository.findStudentsByAgeIsGreaterThanEqual(age);
        if (students.isEmpty()){
            throw new ApiException("There is no students with this age!");
        }
        return students;
    }
}
