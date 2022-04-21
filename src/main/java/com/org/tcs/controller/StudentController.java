package com.org.tcs.controller;

import com.org.tcs.model.Student;
import com.org.tcs.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);
  @Autowired
    StudentService studentService;



    @PostMapping("/create")
    public void createstudent(@RequestBody Student student){
        logger.info("createstudent method :start");
        studentService.createStudent(student);
        logger.info("createstudent method :end");

    }

    @GetMapping("/getAll")
    public List<Student>getAllStudent(){
        List<Student>stulist =studentService.getAllStudent();
        return stulist;
    }


    @PutMapping("/update")
    public void updatestudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable Integer id){
        Student srt=studentService.findById(id);
        return srt;
    }
    @DeleteMapping("/deleteByAddress/{address}")
    public String deleteByAddress(@PathVariable String address){
        String srm  =studentService.deleteByAddress(address);
        return srm;

    }


    @PutMapping("/updatePnoBasedOnAddress/{name}")
    public String updatePnoBasedOnAddress(@PathVariable String name){
        logger.info("updatePnoBasedOnAddress method :start");

        String s=null;
       try{ s=studentService.updatePnoBasedOnAddress(name);}
       catch (Exception e){
           logger.error(e.getMessage());
       }

        logger.info("updatePnoBasedOnAddress method :end");
        return s;
    }

}
