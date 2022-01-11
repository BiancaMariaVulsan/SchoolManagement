package com.bianca.Models;

public class Teacher extends Person {
    private float salary;
    private Discipline discipline;

    public Teacher(String id, String name, String address, float salary, Discipline disciplines) {
        super(id, name, address);
        this.salary = salary;
        this.discipline = disciplines;
    }

    public Teacher(String name, String address, float salary, Discipline disciplines) {
        super(name, address);
        generateId();
        this.salary = salary;
        this.discipline = disciplines;
    }

    public void generateId() {
        int randomNr = (int)(Math.random() * 100);
        this.setId(this.getFirstLetterName() + randomNr + "");
    }

    public void gradeStudent(Student student, int valueGrade) {
        Grade grade = new Grade(valueGrade, student, this.discipline);
    }
}
