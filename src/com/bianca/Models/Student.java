package com.bianca.Models;

import com.bianca.Errors.NumberOutOfRangeException;

import java.util.ArrayList;

public class Student extends Person {

    private boolean scholarship;
    private int yearOfStudy;
    private ArrayList<Grade> grades;

    public Student(String id, String name, String address, boolean scholarship, int yearOfStudy) {
        super(id, name, address);
        this.scholarship = scholarship;
        setYearOfStudy(yearOfStudy);
    }

    public Student(String name, String address, boolean scholarship, int yearOfStudy) {
        super(name, address);
        generateId();
        this.scholarship = scholarship;
        setYearOfStudy(yearOfStudy);
    }

    public void generateId() {
        int randomNr = (int)(Math.random() * 100);
        this.setId(this.getFirstLetterName() + randomNr + "");
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    public void setYearOfStudy(int yearOfStudy) {
        try {
            if(yearOfStudy >=0 && yearOfStudy <=12) {
                this.yearOfStudy = yearOfStudy;
            } else {
                throw new NumberOutOfRangeException("The year of study has an unvalid value!");
            }
        } catch (NumberOutOfRangeException e) {
            e.printStackTrace();
        }
    }


    public void setGrade(Grade grade) {
        grades.add(grade);
    }
}
