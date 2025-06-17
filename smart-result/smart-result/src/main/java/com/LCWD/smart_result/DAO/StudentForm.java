package com.LCWD.smart_result.DAO;

import java.util.Date;
import java.util.List;

public class StudentForm {

    String name;
    String rollNumber;
    String email;
    String gender;
    String dob;
    String schoolName;
    List<Marks> marks;

    public String getName() {
        return name;
    }



    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }
}
