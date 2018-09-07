package com.lanu.rest_test;

import com.lanu.rest_test.domains.Student;
import com.lanu.rest_test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestTestApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(RestTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        Student student1 = new Student("Serhiy", "Khabenyuk");
        Student student2 = new Student("Natalia", "Khabenyuk");
        Student student3 = new Student("Oleksandr", "Khabenyuk");
        Student student4 = new Student("Igor", "Khabenyuk");
        Student student5 = new Student("Andriy", "Gudzovskiy");
        Student student6 = new Student("Oleg", "Zablotskiy");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        saveStudents(students);
    }

    private void saveStudents(List<Student> students){
        students.stream().forEach((s) -> studentService.save(s));
    }
}
