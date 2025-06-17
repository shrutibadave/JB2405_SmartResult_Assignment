package com.LCWD.smart_result.Repository;

import com.LCWD.smart_result.DAO.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findByRollNumber(String rollNo);
}
