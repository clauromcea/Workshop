package ro.axonsoft.internship.main;

import ro.axonsoft.internship.api.*;
import ro.axonsoft.internship.impl.algorithm.ResultWriter;
import ro.axonsoft.internship.impl.algorithm.SearchAlgorithm;
import ro.axonsoft.internship.impl.algorithm.WorkshopToStudentDistributor;
import ro.axonsoft.internship.impl.entity.Student;
import ro.axonsoft.internship.impl.entity.Workshop;
import ro.axonsoft.internship.impl.reader.StudentReader;
import ro.axonsoft.internship.impl.reader.WorkshopReader;

import java.io.IOException;
import java.util.*;

public class Launcher {
    
    public static void main(String[] args) {

        List<StudentDescriptor> students = new ArrayList<StudentDescriptor>();
        List<WorkshopDescriptor> workshops = new ArrayList<WorkshopDescriptor>();
        StudentReader studentReader = new StudentReader();
        WorkshopReader workshopReader = new WorkshopReader();
        Writer resultWriter = new ResultWriter();
        Map<String, List<WorkshopDescriptor>> workshopsMap = new HashMap<String, List<WorkshopDescriptor>>();
        Iterator<StudentDescriptor> iteratorStudents;
        SearchAlgorithm searchAlgorithm;
        List<SearchResult> results = new ArrayList<SearchResult>();

        students = studentReader.loadStudents();
        workshops = workshopReader.loadWorkshops();

        iteratorStudents = students.iterator();

        workshopsMap = WorkshopToStudentDistributor.sortWorkshopsByDiscipline(workshops);
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
}
