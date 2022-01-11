package com.bianca.Models;

import com.bianca.Errors.EnrollException;

import java.util.HashMap;
import java.util.Map;

public class TeachEnrollment implements Enrollment {

    private static Map<Teacher, School> teacherSchoolMap = new HashMap<>();

    private void changeTeacherId(Teacher teacher, School school) {
        teacher.setId(teacher.getName() + school.getFirstLetterName());
    }

    public void enroll(Teacher teacher, School school) {
        try{
            if(teacherSchoolMap.containsKey(teacher) && teacherSchoolMap.containsKey(school)) {
                throw new EnrollException("Teacher " + teacher.getName() + " was already enrolled in school " + school.getName());
            } else {
                teacherSchoolMap.put(teacher, school);
                changeTeacherId(teacher, school);
            }
        } catch (EnrollException e) {
            e.printStackTrace();
        }
    }

    public void unenroll(Teacher teacher, School school) {
        try{
            if(teacherSchoolMap.containsKey(teacher) && teacherSchoolMap.containsKey(school)) {
                teacherSchoolMap.remove(teacher, school);
            } else {
                throw new EnrollException("Teacher " + teacher.getName() + " is not enrolled in school " + school.getName());
            }
        } catch (EnrollException e) {
            e.printStackTrace();
        }
    }
}
