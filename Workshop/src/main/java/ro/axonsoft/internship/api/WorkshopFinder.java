package ro.axonsoft.internship.api;

public interface WorkshopFinder {
    /**
     * Search the maximum set of workshops the student can attend
     * @param studentDescription the description of the student
     * @return the result of the search made for the student
     */
    SearchResult getWorkshops(StudentDescriptor studentDescriptor);
}
