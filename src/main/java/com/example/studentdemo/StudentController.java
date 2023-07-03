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

    @DeleteMapping("/delete")
    public String deletestudent(@RequestParam("id") int admnNo){
        studentDB.remove(admnNo);
        return "Student Deleted succesfully";
    }

    @PutMapping("/update_coures")
    public Student updatecourse(@RequestParam("id") int admnNo,@RequestParam("course") String newCourse){
        if(!studentDB.containsKey(admnNo)){
            throw new RuntimeException("Student doesn't exist");
        }
        Student student=studentDB.get(admnNo);
        student.setCourse(newCourse);
        return student;
    }

    @GetMapping("/get-total")
    public int getTotalStudent(){
        int total=0;
        for(int admnNo: studentDB.keySet()){
            if(studentDB.get(admnNo).getAge()>25){
                total++;
            }
        }
        return total;
    }
}
