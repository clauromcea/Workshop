package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.impl.entity.Workshop;

import java.util.*;

public class WorkshopToStudentDistributor {

    /**
     * Converts the list of workshops to map of lists of workshops sorted by discipline for a faster search
     * @param workshopList is the list of all read workshops
     * @return a map of lists of workshops sorted by discipline
     */
    public Map<String, List<WorkshopDescriptor>> sortWorkshopsByDiscopline(@org.jetbrains.annotations.NotNull List<WorkshopDescriptor> workshopList){

        Map<String, List<WorkshopDescriptor>> workshopMap = new HashMap<String, List<WorkshopDescriptor>>();
        Iterator<WorkshopDescriptor> iteratorWorkshopList = workshopList.iterator();
        WorkshopDescriptor workshop = new Workshop();

        while(iteratorWorkshopList.hasNext()){
            workshop = iteratorWorkshopList.next();

            if(!workshopMap.containsKey(workshop.getDiscipline())){
                workshopMap.put(workshop.getDiscipline(), new ArrayList<WorkshopDescriptor>());
            }
            else{
                workshopMap.get(workshop.getDiscipline()).add(workshop);
            }
        }

        return workshopMap;
    }
}
