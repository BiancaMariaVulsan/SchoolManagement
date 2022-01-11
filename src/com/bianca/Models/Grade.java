package com.bianca.Models;

import com.bianca.Errors.GradeOutOfBoundsException;

public class Grade {
    private float value;
    private Student student;
    private Discipline discipline;

    public Grade(float value, Student student, Discipline discipline) {
        this.value = value;
        this.student = student;
        student.setGrade(this);
        this.discipline = discipline;
    }

    public void setValue(float value) {
        try {
            if(value >= 1 && value <=10) {
                this.value = value;
            } else {
                throw new GradeOutOfBoundsException(value + "is not a valid grade!");
            }
        } catch (GradeOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
