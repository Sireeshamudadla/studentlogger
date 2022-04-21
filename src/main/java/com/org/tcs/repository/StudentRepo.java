package com.org.tcs.repository;

import com.org.tcs.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Transactional
    String deleteByAddress(String address);

    @Transactional
    List<Student> findByAddress(String address);


}
