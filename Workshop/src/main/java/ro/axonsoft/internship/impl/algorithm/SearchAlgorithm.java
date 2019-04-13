package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.SearchResult;
import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.api.WorkshopFinder;
import ro.axonsoft.internship.impl.entity.Workshop;

import java.util.*;

public class SearchAlgorithm implements WorkshopFinder {

    private Map<String, WorkshopDescriptor> workshopMap;

    public SearchAlgorithm(Map<String, WorkshopDescriptor> workshopMap) {
        this.workshopMap = workshopMap;
    }

    /**
     * Search the maximum set of workshops the student can attend
     * @param studentDescriptor the description of the student
     * @return the result of the search made for the student
     */
    public SearchResult getWorkshops(StudentDescriptor studentDescriptor) {

        List<WorkshopDescriptor> workshopListResult = new ArrayList<WorkshopDescriptor>();

        

        return new Result(studentDescriptor.getName(), workshopListResult);
    }

}
