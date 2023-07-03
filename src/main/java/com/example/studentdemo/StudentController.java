package com.example.studentdemo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
public class StudentController {

    HashMap<Integer,Student>studentDB=new HashMap<>();
    @GetMapping("/get_info")
    public Student getstudent(@RequestParam("id") int admnNo){
        return studentDB.get(admnNo);
    }
     @PostMapping("/add")
    public String addstudent(Student student){
        studentDB.put(student.getAdmnNo(),student);
        return "Student added succesfully";
    }

    @GetMapping("/get/{id}")
    public Student getstudentbyPath(@PathVariable("id") int admnNo){
        return studentDB.get(admnNo);
    }
}
