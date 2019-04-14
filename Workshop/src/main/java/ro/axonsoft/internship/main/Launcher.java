package ro.axonsoft.internship.main;

import ro.axonsoft.internship.api.*;
import ro.axonsoft.internship.impl.algorithm.ResultWriter;
import ro.axonsoft.internship.impl.algorithm.SearchAlgorithm;
import ro.axonsoft.internship.impl.algorithm.ListToMapConverter;
import ro.axonsoft.internship.impl.convertor.StudentConverter;
import ro.axonsoft.internship.impl.convertor.TimeConverter;
import ro.axonsoft.internship.impl.convertor.WorkshopConverter;
import ro.axonsoft.internship.impl.model.Student;
import ro.axonsoft.internship.impl.model.Workshop;
import ro.axonsoft.internship.impl.reader.StudentReader;
import ro.axonsoft.internship.impl.reader.WorkshopReader;

import java.io.IOException;
import java.util.*;

public class Launcher {

    public static void main(String[] args) {
        Reader<Student> studentReader = getStudentReader();
        Reader workshopReader = getWorkshopReader();

        Writer resultWriter = new ResultWriter();
        Map<String, List<WorkshopDescriptor>> workshopsMap;
        Iterator<Student> iteratorStudents;
        SearchAlgorithm searchAlgorithm;
        List<SearchResult> results = new ArrayList<>();

        List<Student> students = studentReader.readFile("ro/axonsoft/internship/main/resources/students.csv");
        List<Workshop> workshops = workshopReader.readFile("ro/axonsoft/internship/main/resources/workshops.cs");
        iteratorStudents = students.iterator();
        workshopsMap = ListToMapConverter.sortWorkshopsByDiscipline(workshops);
        searchAlgorithm = new SearchAlgorithm(workshopsMap);

        while (iteratorStudents.hasNext()){
            results.add(searchAlgorithm.getWorkshops(iteratorStudents.next()));
        }

        try {
            resultWriter.writeResult(results);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    private static Reader<Student> getStudentReader() {
        TimeConverter timeConverter = new TimeConverter();
        Converter<Student, String> studentStringConverter = new StudentConverter(timeConverter);
        return new StudentReader(studentStringConverter);
    }

    private static Reader<Workshop> getWorkshopReader() {
        TimeConverter timeConverter = new TimeConverter();
        Converter<Workshop, String> workshopStringConverter = new WorkshopConverter(timeConverter);
        return new WorkshopReader(workshopStringConverter);
    }
}
