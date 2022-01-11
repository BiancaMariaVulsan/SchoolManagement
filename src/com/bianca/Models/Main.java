package com.bianca.Models;

import com.bianca.Repository.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static ArrayList<Student> students;
    static ArrayList<Teacher> teachers;
    static ArrayList<School> schools;
    static ArrayList<Discipline> disciplines;

    public static void init() {
        FileReader fileReader = new FileReader();
        fileReader.readData();
        students = fileReader.getStudents();
        teachers = fileReader.getTeachers();
        schools = fileReader.getSchools();
        disciplines = fileReader.getDisciplines();

        Student student1 = students.get(0);
        Student student2 = students.get(1);
        Discipline discipline1 = disciplines.get(0);
        Discipline discipline2 = disciplines.get(1);
        StudyEnrollment studyEnrollment = new StudyEnrollment();
        studyEnrollment.enroll(student1, discipline1);
        studyEnrollment.enroll(student2, discipline1);
    }

    /** Display all the students */
    public static void firstTask() {
        for(Student student : students) {
            System.out.println(student.getName());
        }
    }

    /** Display discipline which has the biggest nr of students enrolled */
    public static void secondTask() {
        StudyEnrollment studyEnrollment = new StudyEnrollment();
        Map<Student, Discipline> map = studyEnrollment.getStudentDisciplineMap();
        Map<Discipline, Integer> countMap = new HashMap<>();
        // initialize all disciplines in the map
        for(Discipline discipline : disciplines) {
            countMap.put(discipline, 0);
        }
        // find how many times each discipline was attended
        for(Map.Entry<Student, Discipline> entry : map.entrySet()) {
            Discipline discipline = entry.getValue();
            int value = countMap.get(discipline);
            value++;
            countMap.replace(discipline, value);
        }
        // find max
        int max = 0;
        Discipline maxKey = disciplines.get(0);
        for(Map.Entry<Discipline, Integer> entry : countMap.entrySet()) {
            int value = entry.getValue();
            if(max < value) {
                max = value;
                maxKey = entry.getKey();
            }
        }
        System.out.println(maxKey.getName());
    }

    public static void main(String[] args) {

        init();
        firstTask();
        secondTask();
    }
}
