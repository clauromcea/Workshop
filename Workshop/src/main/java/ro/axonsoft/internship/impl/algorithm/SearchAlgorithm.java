package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.SearchResult;
import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.api.WorkshopFinder;
import ro.axonsoft.internship.impl.model.Result;
import ro.axonsoft.internship.impl.model.Workshop;

import java.util.*;

public class SearchAlgorithm implements WorkshopFinder {
    private Map<String, List<WorkshopDescriptor>> workshopsMap;

    public SearchAlgorithm(Map<String, List<WorkshopDescriptor>> workshopsMap) {
        this.workshopsMap = workshopsMap;
    }

    /**
     * Search the maximum set of workshops the student can attend
     * @param studentDescriptor the description of the student
     * @return the result of the search made for the student
     */
    public SearchResult getWorkshops(StudentDescriptor studentDescriptor) {
        List<WorkshopDescriptor> matchingWorkshops = new ArrayList<WorkshopDescriptor>();
        List<WorkshopDescriptor> maximalWorkshopsSet = new ArrayList<WorkshopDescriptor>();

        matchingWorkshops = getMatchingWorkshops(studentDescriptor, this.workshopsMap);
        Collections.sort(matchingWorkshops);
        maximalWorkshopsSet = getMaximalSet(matchingWorkshops);

        return new Result(studentDescriptor.getName(), maximalWorkshopsSet);
    }

    /**
     * Get all the workshops that match the students' attended disciplines
     * and that take place in the sudent availability interval
     * @param studentDescriptor
     * @param workshopsMap
     * @return a list of workshops that match whit the discipline and time interval of student availability
     */
    private List<WorkshopDescriptor> getMatchingWorkshops(StudentDescriptor studentDescriptor, Map<String , List<WorkshopDescriptor>> workshopsMap){
        List<WorkshopDescriptor> matchingWorkshops = new ArrayList<WorkshopDescriptor>();

        for(Map.Entry<String, List<WorkshopDescriptor>> entry: workshopsMap.entrySet()){
            Iterator<String> iteratorDiscipline = studentDescriptor.getDisciplineList().iterator();
            Iterator<WorkshopDescriptor> iteratorWorkshop;
            String discipline;
            WorkshopDescriptor workshop;

            /**
             *
             */
            while(iteratorDiscipline.hasNext()){
                discipline = iteratorDiscipline.next();
                if("all".equals(discipline)) {
                    iteratorWorkshop = entry.getValue().iterator();
                    while (iteratorWorkshop.hasNext()){
                        workshop = iteratorWorkshop.next();
                        if((TimeHelper.convertTimeToInteger(workshop.getTime())
                                >= TimeHelper.convertTimeToInteger(studentDescriptor.getStartTime()))
                                && (TimeHelper.convertTimeToInteger(workshop.getTime())+workshop.getDuration()
                                <= TimeHelper.convertTimeToInteger(studentDescriptor.getEndTime()))){
                            matchingWorkshops.add(workshop);
                        }
                    }
                    //matchingWorkshops.addAll(entry.getValue());
                }else{
                    if (discipline.equals(entry.getKey())) {
                        iteratorWorkshop = entry.getValue().iterator();
                        while (iteratorWorkshop.hasNext()){
                            workshop = iteratorWorkshop.next();
                            if((TimeHelper.convertTimeToInteger(workshop.getTime())
                                    >= TimeHelper.convertTimeToInteger(studentDescriptor.getStartTime()))
                                    && (TimeHelper.convertTimeToInteger(workshop.getTime())+workshop.getDuration()
                                    <= TimeHelper.convertTimeToInteger(studentDescriptor.getEndTime()))){
                                matchingWorkshops.add(workshop);
                            }
                        }
                        //matchingWorkshops.addAll(entry.getValue());
                    }
                }
            }
        }

        return matchingWorkshops;
    }

    /**
     *
     * @param matchingWorkshops
     * @return the maximal set of workshops that a student can attend
     */
    private List<WorkshopDescriptor> getMaximalSet(List<WorkshopDescriptor> matchingWorkshops){
        int length = matchingWorkshops.size();
        //List<List<WorkshopDescriptor>> listOfMaximalSets = new ArrayList<List<WorkshopDescriptor>>(length);
        List<WorkshopDescriptor>[] listOfMaximalSets = new List[length];
        int window;//Time that students need to change rooms
        int maxim;
        Iterator<List<WorkshopDescriptor>> iterator;
        List<WorkshopDescriptor> maximalSet = new ArrayList<WorkshopDescriptor>();
        List<WorkshopDescriptor> workshopsSet;

        /*
        listOfMaximalSets.get(length-1).add(matchingWorkshops.get(length-1));

        iterator = listOfMaximalSets.iterator();
        while (iterator.hasNext()) {
            iterator.next() = new ArrayList<WorkshopDescriptor>();
            iterator.
        }
        */

        listOfMaximalSets[length-1].add(matchingWorkshops.get(length-1));

        for (int i = 0; i < length; i++){
            listOfMaximalSets[i] = new ArrayList<WorkshopDescriptor>();
        }

        for (int i = length-2; i>= 0; i--) {
            maxim = 0;
            for (int j = i + 1; j < length - 1; j++) {
                if (matchingWorkshops.get(j).getRoom().equals(matchingWorkshops.get(i).getRoom())) {
                    window = 0;
                } else {
                    window = 10;
                }

                if ((TimeHelper.convertTimeToInteger(matchingWorkshops.get(j).getTime())
                        >= TimeHelper.convertTimeToInteger(matchingWorkshops.get(i).getTime()) + matchingWorkshops.get(i).getDuration() + window)
                        && (listOfMaximalSets[j].size() > maxim)) {
                    maxim = listOfMaximalSets[j].size();
                }
            }
            listOfMaximalSets[i].add(matchingWorkshops.get(i));
        }
        maxim = 0;

        /*
        iterator = listOfMaximalSets.iterator();
        if(iterator.hasNext()){
            workshopsSet = iterator.next();
            if (workshopsSet.size() > maxim){
                maximalSet = workshopsSet;
            }
        }
        */

        for (int i = 0; i < length; i++){
            if (listOfMaximalSets[i].size() > maxim){
                maximalSet = listOfMaximalSets[i];
            }
        }

        return maximalSet;
    }
}
