package com.bianca.Models;

import com.bianca.Errors.EnrollException;

import java.util.HashMap;
import java.util.Map;

public class StudyEnrollment implements Enrollment {

    private static Map<Student, Discipline> studentDisciplineMap = new HashMap<>();

    public Map<Student, Discipline> getStudentDisciplineMap() {
        return studentDisciplineMap;
    }

    public void enroll(Student student, Discipline discipline) {
        try{
            if(studentDisciplineMap.containsKey(student) && studentDisciplineMap.containsKey(discipline)) {
                throw new EnrollException("Student " + student.getName() + " was already enrolled in discipline " + discipline.getName());
            } else {
                studentDisciplineMap.put(student, discipline);
            }
        } catch (EnrollException e) {
            e.printStackTrace();
        }
    }

    public void unenroll(Student student, Discipline discipline) {
        try{
            if(studentDisciplineMap.containsKey(student) && studentDisciplineMap.containsKey(discipline)) {
                studentDisciplineMap.remove(student, discipline);
            } else {
                throw new EnrollException("Student " + student.getName() + " is not enrolled in discipline " + discipline.getName());
            }
        } catch (EnrollException e) {
            e.printStackTrace();
        }
    }
}
