package com.bianca.Repository;

import com.bianca.Models.Discipline;
import com.bianca.Errors.InvalidDisciplineExcption;
import com.bianca.Models.School;
import com.bianca.Models.Student;
import com.bianca.Models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    File file = new File("D:\\FACULTATE\\ANUL II\\sem 1\\OOP\\School\\src\\com\\bianca\\Repository\\school");
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private ArrayList<School> schools = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public ArrayList<School> getSchools() {
        return schools;
    }

    public void readData() {
        try {
            Scanner scanner = new Scanner(file);
            String input;

            // read schools
            input = scanner.nextLine();
            while (!input.isEmpty()) {
                School school = new School(input);
                schools.add(school);
                if(scanner.hasNext()) {
                    input = scanner.nextLine();
                } else {
                    break;
                }
            }

            // read disciplines
            input = scanner.nextLine();
            while (!input.isEmpty()) {
                Discipline discipline = new Discipline(input);
                disciplines.add(discipline);
                if(scanner.hasNext()) {
                    input = scanner.nextLine();
                } else {
                    break;
                }
            }

            // read students
            input = scanner.nextLine();
            while (!input.isEmpty()) {
                Student student = parseStudent(input);
                students.add(student);
                if(scanner.hasNext()) {
                    input = scanner.nextLine();
                } else {
                    break;
                }
            }

            // read teachers
            input = scanner.nextLine();
            while (!input.isEmpty()) {
                Teacher teacher = parseTeacher(input);
                teachers.add(teacher);
                if(scanner.hasNext()) {
                    input = scanner.nextLine();
                } else {
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Student parseStudent(String input) {
        String[] tockens = input.split(",");
        return new Student(tockens[0], tockens[1], Boolean.valueOf(tockens[2]), Integer.valueOf(tockens[3]));
    }

    private Teacher parseTeacher(String input) {
        String[] tockens = input.split(",");
        Discipline discipline = findDiscipline(tockens[3]);
        return new Teacher(tockens[0], tockens[1], Float.valueOf(tockens[2]), discipline);
    }

    private Discipline findDiscipline(String name) {
        try {
            for (Discipline discipline : disciplines) {
                if(discipline.getName().compareTo(name) == 0) {
                    return discipline;
                }
            }
            throw new InvalidDisciplineExcption("This discipline is not available");
        } catch (InvalidDisciplineExcption e) {
            e.printStackTrace();
        }
        return null;
    }

}
