package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//data access interface
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //find a user by email
    // will produce SQL: SELECT * FROM student WHERE email =?
    //JBQL
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
