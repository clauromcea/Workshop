package ro.axonsoft.internship.impl.reader;

import ro.axonsoft.internship.api.Convertor;
import ro.axonsoft.internship.api.Reader;
import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.impl.ReaderException;
import ro.axonsoft.internship.impl.model.Student;
import ro.axonsoft.internship.impl.model.TimeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentReader implements Reader<StudentDescriptor>{
    private Convertor<Student, String> convertor;

    public StudentReader(Convertor<Student, String> convertor) {
        this.convertor = convertor;
    }

    public List<StudentDescriptor> readFile(String filename) {
        List<StudentDescriptor> result = new ArrayList<StudentDescriptor>();
        Stream<String> lines = RowReader.readRowData(filename, getClass());
        lines.forEach((String string) -> {
            result.add(convertor.convert(string));
        });

        lines.close();

        return result;
    }

    public StudentDescriptor readLine(String line) throws ReaderException {
        return null;
    }

    public List<StudentDescriptor> loadStudents(){
        List<StudentDescriptor> studentList = new ArrayList<StudentDescriptor>();
        List<String> disciplineList;

        disciplineList = new ArrayList<String>();
        disciplineList.add("pictura");
        studentList.add(new Student("Andrei Popescu", new TimeInfo(10, 30), new TimeInfo(15,00), disciplineList));

        disciplineList = new ArrayList<String>();
        disciplineList.add("all");
        studentList.add(new Student("John Doe", new TimeInfo(8, 00), new TimeInfo(12, 55), disciplineList));

        disciplineList = new ArrayList<String>();
        disciplineList.add("muzica");
        disciplineList.add("pictura");
        studentList.add(new Student("Maria Ionas", new TimeInfo(9, 00), new TimeInfo(18, 00), disciplineList));

        disciplineList = new ArrayList<String>();
        disciplineList.add("lectura");
        disciplineList.add("muzica");
        disciplineList.add("natura");
        studentList.add(new Student("Mihai Rusu", new TimeInfo(8, 30), new TimeInfo(15, 30), disciplineList));

        disciplineList = new ArrayList<String>();
        disciplineList.add("all");
        studentList.add(new Student("Ioana Artean", new TimeInfo(12, 15), new TimeInfo(15, 30), disciplineList));

        return studentList;
    }
}
