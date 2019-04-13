package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.SearchResult;
import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.api.WorkshopFinder;
import ro.axonsoft.internship.impl.entity.Result;

import java.util.*;

public class SearchAlgorithm implements WorkshopFinder {

    private Map<String, List<WorkshopDescriptor>> workshopMap;

    public SearchAlgorithm(Map<String, List<WorkshopDescriptor>> workshopMap) {
        this.workshopMap = workshopMap;
    }

    /**
     * Search the maximum set of workshops the student can attend
     * @param studentDescriptor the description of the student
     * @return the result of the search made for the student
     */
    public SearchResult getWorkshops(StudentDescriptor studentDescriptor) {

        List<WorkshopDescriptor> workshopListResult = new ArrayList<WorkshopDescriptor>();

        for(Map.Entry<String, List<WorkshopDescriptor>> entry: workshopMap.entrySet()){

            Iterator<String> iteratorDisciplineStudent = studentDescriptor.getDisciplineList().iterator();

            String discipline;

            while(iteratorDisciplineStudent.hasNext()){
                discipline = iteratorDisciplineStudent.next();
                if("all".equals(discipline)) {
                    workshopListResult.addAll(entry.getValue());
                }else{
                    if (discipline.equals(entry.getKey())) {
                        workshopListResult.addAll(entry.getValue());
                    }
                }
            }
        }

        return new Result(studentDescriptor.getName(), workshopListResult);
    }

}
