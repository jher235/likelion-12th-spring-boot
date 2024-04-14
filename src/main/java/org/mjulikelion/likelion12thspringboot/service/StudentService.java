package org.mjulikelion.likelion12thspringboot.service;

import lombok.AllArgsConstructor;
import org.mjulikelion.likelion12thspringboot.Student;
import org.mjulikelion.likelion12thspringboot.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    public List<Student> getAllStudents(){
        return this.studentRepository.getAllStudents();
    }

    public Student getStudentById(String id){
        return this.studentRepository.getStudentById(id);
    }



    public void createStudent(Student student){
        this.studentRepository.createStudent(student);
    }


    public void deleteStudent(String id){
       this.studentRepository.deleteStudentById(id);
    }


    public void updateStudentById(String id, String name){
        this.studentRepository.updateStudentById(id, name);
    }


}
