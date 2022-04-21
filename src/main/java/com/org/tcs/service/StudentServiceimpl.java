package com.org.tcs.service;

import com.org.tcs.controller.StudentController;
import com.org.tcs.model.Student;
import com.org.tcs.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService  {
    Logger logger = LoggerFactory.getLogger(StudentServiceimpl.class);

    @Autowired
    StudentRepo studentRepo;

    @Override
    public void createStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student>stuhk=studentRepo.findAll();
        return stuhk;
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student findById(Integer id) {
        Student student=studentRepo.getById(id);
        return student;
    }

    @Override
    public String deleteByAddress(String address) {
        studentRepo.deleteByAddress(address);

        return "success";
    }

    @Override
    public String updatePnoBasedOnAddress(String name) {
        logger.info("updatePnoBasedOnAddress start");
      try{  List<Student>list=studentRepo.findByAddress(name);

        for(int i=0;i<list.size();i++){

            Student s=list.get(i);
            s.setPno(90909.0);

            studentRepo.save(s);

        }
      }catch (Exception e){
          throw new RuntimeException();
      }
        logger.info("updatePnoBasedOnAddress end");
        return "success fully updatePnoBasedOnAddress";
    }


}
