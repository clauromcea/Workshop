package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.impl.model.Workshop;

import java.util.*;

public class ListToMapConverter {
    /**
     * Converts the list of workshops to map of lists of workshops sorted by discipline for a faster search
     * @param workshopList is the list of all read workshops
     * @return a map of lists of workshops sorted by discipline
     */
    public static Map<String, List<WorkshopDescriptor>> sortWorkshopsByDiscipline(@org.jetbrains.annotations.NotNull List<Workshop> workshopList){
        Map<String, List<WorkshopDescriptor>> workshopMap = new HashMap<>();
        Iterator<Workshop> iteratorWorkshopList = workshopList.iterator();
        WorkshopDescriptor workshop;

        while(iteratorWorkshopList.hasNext()){
            workshop = iteratorWorkshopList.next();

            if(!workshopMap.containsKey(workshop.getDiscipline())){
                workshopMap.put(workshop.getDiscipline(), new ArrayList<>());
                workshopMap.get(workshop.getDiscipline()).add(workshop);
            }
            else{
                workshopMap.get(workshop.getDiscipline()).add(workshop);
            }
        }

        return workshopMap;
    }
}
