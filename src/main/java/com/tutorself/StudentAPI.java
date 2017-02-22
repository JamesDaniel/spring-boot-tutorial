package com.tutorself;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class StudentAPI {

    private static Map<Integer, Student> studentDB;

    @RequestMapping("/students")
    public Student searchStudent(
            @RequestParam(name = "studentId", required = true) Integer studentId) {
        return studentDB.get(studentId);
    }

    public static void main(String[] args) throws Exception {
        createStudentList();
        SpringApplication.run(StudentAPI.class, args);
    }

    private static void createStudentList() {
        studentDB = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Student student = new Student(i, "Name-" + i, "CS-" + i, "Computer Science", "CS", "2nd");
            studentDB.put(student.getStudentId(), student);
        }
    }
}