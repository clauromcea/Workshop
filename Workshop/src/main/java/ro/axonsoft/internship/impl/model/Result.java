package ro.axonsoft.internship.impl.model;

import ro.axonsoft.internship.api.SearchResult;
import ro.axonsoft.internship.api.WorkshopDescriptor;

import java.util.Iterator;
import java.util.List;

public class Result implements SearchResult {
    private String studentName;
    private List<WorkshopDescriptor> workshops;

    public Result(String studentName, List<WorkshopDescriptor> workshops) {
        this.studentName = studentName;
        this.workshops = workshops;
    }

    /**
     * The student name for which the search was made
     */
    public String getStudentName() {
        return this.studentName;
    }

    /**
     * The descriptions of the workshops found for the student
     */
    public List<WorkshopDescriptor> getWorkshops() {
        return this.workshops;
    }

    @Override
    public String toString() {
        String string = getStudentName();
        Iterator<WorkshopDescriptor> iterator = workshops.iterator();

        while(iterator.hasNext()){
            string = string + "\n" + iterator.next().toString();
        }
        return string;
    }
}
