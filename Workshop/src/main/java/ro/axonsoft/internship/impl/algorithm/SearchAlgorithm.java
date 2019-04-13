package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.SearchResult;
import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.api.WorkshopFinder;
import ro.axonsoft.internship.impl.Workshop;

import java.util.*;

public class SearchAlgorithm implements WorkshopFinder {
    /**
     *
     * @param studentDescriptor
     * @return
     */
    public SearchResult getWorkshops(StudentDescriptor studentDescriptor) {
        return null;
    }

    /**
     * Converts the list of workshops to map of lists of workshops sorted by discipline for a faster search
     * @param workshopList is the list of all read workshops
     * @return a map of lists of workshops sorted by discipline
     */
    public Map<String, List<Workshop>> sortWorkshopsByDiscopline(@org.jetbrains.annotations.NotNull List<Workshop> workshopList){

        Map<String, List<Workshop>> workshopMap = new HashMap<String, List<Workshop>>();
        Iterator<Workshop> iteratorWorkshopList = workshopList.iterator();
        Workshop workshop = new Workshop();

        while(iteratorWorkshopList.hasNext()){
            workshop = iteratorWorkshopList.next();

            if(!workshopMap.containsKey(workshop.getDiscipline())){
                workshopMap.put(workshop.getDiscipline(), new ArrayList<Workshop>());
            }
            else{
                workshopMap.get(workshop.getDiscipline()).add(workshop);
            }
        }

        return workshopMap;
    }
}
