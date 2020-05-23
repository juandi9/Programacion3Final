package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(int id){
        return studentRepository.findById(id).get();
    }

    public boolean addStudent(Student student){
        if (student.getProm()>=0 && student.getProm()<=5){
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id){
        try {
            studentRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException exception){
            return false;
        }
    }

    public boolean findStudent(Student student) {
        try {
            studentRepository.findById(student.getId()).get();
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }

    }

    public List<Student> bestStudents (){

        return studentRepository.findAll().stream().sorted(Comparator.comparing(Student::getProm).reversed()).limit(5).collect(Collectors.toList());

    }
}
