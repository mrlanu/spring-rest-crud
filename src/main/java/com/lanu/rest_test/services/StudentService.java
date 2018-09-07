package com.lanu.rest_test.services;

import com.lanu.rest_test.domains.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);
    Student findByStudentId(Integer id);
    List<Student> findAll();
    List<Student> findAllByLastName(String lastName);
}
