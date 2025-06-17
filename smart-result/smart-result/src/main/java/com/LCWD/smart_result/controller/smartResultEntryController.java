package com.LCWD.smart_result.controller;

import com.LCWD.smart_result.DAO.Student;
import com.LCWD.smart_result.DAO.StudentForm;
import com.LCWD.smart_result.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/smartResult")
public class smartResultEntryController {

    @Autowired
    StudentService studentService;

    @GetMapping("/index")
    public String entry() {
        return "index";
    }
    @GetMapping("/addResult")
    public String addResult(Model model) {
        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);
        return "add_result";
    }
    @GetMapping("/viewResult")
    public String viewResult() {
        return "view_result";
    }
    @PostMapping("/process-form")
    public String saveStudent(@ModelAttribute StudentForm studentForm) {
            studentService.saveStudent(studentForm);
        return "result_success";
    }
    @PostMapping("/result_data")
    public String getStudentResult(@RequestParam("rollNumber") String rollNo, Model model) {
        Student studentForm = studentService.getStudentByRollNo(rollNo);
        AtomicInteger totalMarks= new AtomicInteger();
        AtomicInteger totalMaxMarks= new AtomicInteger();
        int  percentage=0;
        char totalGrade;
        String feedback;
        studentForm.getMarks().forEach(student -> {
            totalMarks.addAndGet(student.getMarks());
            totalMaxMarks.addAndGet(student.getMaxMarks());
        });
        percentage = (totalMarks.get() * 100) / totalMaxMarks.get();
        if(percentage >= 90) {
            totalGrade = 'A';
        } else if(percentage >= 80) {
            totalGrade = 'B';
        } else if(percentage >= 70) {
            totalGrade = 'C';
        } else if(percentage >= 60) {
            totalGrade = 'D';
        } else if(percentage >= 50) {
            totalGrade = 'E';
        } else {
            totalGrade = 'F';
        }
        if(percentage >= 60) {
            feedback = "Congratulations! You have passed.";
        } else {
            feedback = "Unfortunately, you have failed. Please try again.";
        }
        if(studentForm != null) {
            model.addAttribute("student", studentForm);
            model.addAttribute("feedback", feedback);
            model.addAttribute("totalMarks", totalMarks.get());
            model.addAttribute("totalMaxMarks", totalMaxMarks.get());
            model.addAttribute("percentage", percentage);
            model.addAttribute("totalGrade", totalGrade);

        } else {
            return "result_not_found";
        }
        return "result_data";
    }


}
