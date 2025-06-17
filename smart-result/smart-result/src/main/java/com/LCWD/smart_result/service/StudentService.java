package com.LCWD.smart_result.service;

import com.LCWD.smart_result.DAO.Student;
import com.LCWD.smart_result.DAO.StudentForm;
import com.LCWD.smart_result.Repository.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
   public void saveStudent(StudentForm studentForm) {
       Student student = new Student();
       student.setName(studentForm.getName());
       student.setRollNumber(studentForm.getRollNumber());
       student.setEmail(studentForm.getEmail());
       student.setGender(studentForm.getGender());
       student.setDob(studentForm.getDob());
       student.setSchoolName(studentForm.getSchoolName());
       studentForm.getMarks().forEach(mark -> {
              student.getMarks().add(mark);
              mark.setStudent(student); // Set the student reference in each mark
       });

       studentRepo.save(student);
    }
    public Student getStudentByRollNo(String rollNo) {
        return studentRepo.findByRollNumber(rollNo);
    }
}
