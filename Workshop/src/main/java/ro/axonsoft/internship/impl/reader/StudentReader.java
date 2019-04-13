package ro.axonsoft.internship.impl.reader;

import ro.axonsoft.internship.api.Reader;
import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.impl.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentReader implements Reader<StudentDescriptor> {


    public List<StudentDescriptor> readFile(String filename) {
        return null;
    }

    public Student readLine(String line)  {
        return null;
    }

    public List<StudentDescriptor> loadStudents(){
        List<StudentDescriptor> studentList = new ArrayList<StudentDescriptor>();
        List<String> disciplineList;

        disciplineList = new ArrayList<String>();
        disciplineList.add("pictura");
        studentList.add(new Student("Andrei Popescu", "10:30", "15:00", disciplineList));

        disciplineList = new ArrayList<String>();
        disciplineList.add("all");
        studentList.add(new Student("John Doe", "08:00", "12:55", disciplineList));

        disciplineList = new ArrayList<String>();
        disciplineList.add("muzica");
        disciplineList.add("pictura");
        studentList.add(new Student("Maria Ionas", "09:00", "18:00", disciplineList));

        disciplineList = new ArrayList<String>();
        disciplineList.add("lectura");
        disciplineList.add("muzica");
        disciplineList.add("natura");
        studentList.add(new Student("Mihai Rusu", "08:30", "15:30", disciplineList));

        disciplineList = new ArrayList<String>();
        disciplineList.add("all");
        studentList.add(new Student("Ioana Artean", "12:15", "15:30", disciplineList));

        return studentList;
    }
}
