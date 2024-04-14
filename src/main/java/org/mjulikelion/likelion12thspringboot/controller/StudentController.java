package org.mjulikelion.likelion12thspringboot.controller;

import lombok.AllArgsConstructor;
import org.mjulikelion.likelion12thspringboot.Student;
import org.mjulikelion.likelion12thspringboot.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable String id){
        return service.getStudentById(id);
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED) //의도적으로 201 리턴
    public void createStudent(@RequestBody Student student){//@RequestBody으로 Request Body에서 보내준 데이터를 Student 클래스로 변환 -> 클래스 필드변수와 json 값의 key가 동일하다면 자동으로 변환해줌
        service.createStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
    }

    @PatchMapping("/students/{id}") //@RequestBody에 정보를 보낼 때 String하나만 보낸다면 text로 보내야함 -> 원래는 raw(JSON)으로 정보를 보냄.
    public void updateStudentById(@PathVariable String id, @RequestBody String name){ //url에 id값이 존재하기 때문에 RequestBody를 통해서 바꿀 이름을 받아오고 이를 파라미터 name에 매핑해줌
        service.updateStudentById(id, name);
    }



}
