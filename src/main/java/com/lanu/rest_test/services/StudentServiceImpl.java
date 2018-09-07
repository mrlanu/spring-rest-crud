package com.lanu.rest_test.services;

import com.lanu.rest_test.domains.Student;
import com.lanu.rest_test.repositiries.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findByStudentId(Integer id) {
        return studentRepository.findByStudentId(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllByLastName(String lastName) {
        return studentRepository.findAllByLastName(lastName);
    }
}
