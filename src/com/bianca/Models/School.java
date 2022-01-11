package com.bianca.Models;

import java.util.Set;

public class School {

    private String name;
    private Set<Student> students;
    private Set<Teacher> teachers;

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getFirstLetterName() {
        return this.name.charAt(0);
    }

    public void employTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void fireTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
