package ro.axonsoft.internship.main;

import ro.axonsoft.internship.api.*;
import ro.axonsoft.internship.impl.algorithm.ResultWriter;
import ro.axonsoft.internship.impl.algorithm.SearchAlgorithm;
import ro.axonsoft.internship.impl.algorithm.ListToMapConverter;
import ro.axonsoft.internship.impl.convertor.StudentConvertor;
import ro.axonsoft.internship.impl.convertor.TimeConvertor;
import ro.axonsoft.internship.impl.model.Student;
import ro.axonsoft.internship.impl.reader.StudentReader;
import ro.axonsoft.internship.impl.reader.WorkshopReader;

import java.io.IOException;
import java.util.*;

public class Launcher {
    
    public static void main(String[] args) {
        Reader<Student> studentReader = new StudentReader();
        Reader workshopReader = new WorkshopReader();

        List<StudentDescriptor> students = new ArrayList<StudentDescriptor>();
        List<WorkshopDescriptor> workshops = new ArrayList<WorkshopDescriptor>();

        Writer resultWriter = new ResultWriter();
        Map<String, List<WorkshopDescriptor>> workshopsMap = new HashMap<String, List<WorkshopDescriptor>>();
        Iterator<StudentDescriptor> iteratorStudents;
        SearchAlgorithm searchAlgorithm;
        List<SearchResult> results = new ArrayList<SearchResult>();

        students = studentReader.loadStudents();
        workshops = workshopReader.loadWorkshops();
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

    public static Reader<Student> readStudents(){
        TimeConvertor timeConvertor = new TimeConvertor();
        Convertor<Student, String> studentStringConvertor = new StudentConvertor(timeConvertor);

        return new StudentReader
    }
}
