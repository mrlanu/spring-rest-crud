package com.lanu.rest_test.repositiries;

import com.lanu.rest_test.domains.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByStudentId(Integer id);
    List<Student> findAllByLastName(String lastName);
}
