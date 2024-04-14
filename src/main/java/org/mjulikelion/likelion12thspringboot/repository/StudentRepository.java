package org.mjulikelion.likelion12thspringboot.repository;

import org.mjulikelion.likelion12thspringboot.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //DB와 상호작용
public class StudentRepository {

    private final List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudents(){
        return  this.studentList;
    }

    public  Student getStudentById(String id){
        for(Student student : this.studentList){
            if(student.getId().equals(id)){
                return student;
            }
        }
        throw new IllegalArgumentException("Student"+ id +" Not Found");
    }

    public void updateStudentById(String id, String name){
        for (Student s: this.studentList){
            if(s.getId().equals(id)){   //존재하는 객체 삭제 후 다시 생성
                this.studentList.remove(s);
                this.studentList.add(new Student(id, name));
                return;
            }
        }
        throw new IllegalArgumentException("Student"+ id +" Not Found");
    }

    public void createStudent(Student student){
        for (Student s: this.studentList){
            if (s.getId().equals(student.getId())){ //이미 존재한다면
                throw  new IllegalArgumentException("Student"+ s.getId()+" Aready Exist");
            }
        }
        this.studentList.add(student);
    }

    public void deleteStudentById(String id) {
        for (Student student : this.studentList) {
            if (student.getId().equals(id)) {
                this.studentList.remove(student);
                return;
            }
        }
        throw new IllegalArgumentException("Student"+ id +" Not Found");
    }



}
