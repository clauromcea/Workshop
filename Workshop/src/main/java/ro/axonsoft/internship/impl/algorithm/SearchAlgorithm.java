package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.SearchResult;
import ro.axonsoft.internship.api.StudentDescriptor;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.api.WorkshopFinder;
import ro.axonsoft.internship.impl.model.Result;

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
        //List<WorkshopDescriptor> maximalWorkshopsSet = new ArrayList<WorkshopDescriptor>();
        List<List<WorkshopDescriptor>> maximalWorkshopsSetList;

        matchingWorkshops = getMatchingWorkshops(studentDescriptor, this.workshopsMap);
        Collections.sort(matchingWorkshops);
        //maximalWorkshopsSet = getMaximalSet(matchingWorkshops);
        maximalWorkshopsSetList = getMaximalSet(matchingWorkshops);

        return new Result(studentDescriptor.getName(), maximalWorkshopsSetList.get(0));
    }
    /**
     * Get all the workshops that match the students' attended disciplines
     * and that take place in the sudent availability interval
     * @param studentDescriptor
     * @param workshopsMap
     * @return a list of workshops that match whit the discipline and time interval of student availability
     */
    private List<WorkshopDescriptor> getMatchingWorkshops(StudentDescriptor studentDescriptor, Map<String , List<WorkshopDescriptor>> workshopsMap){
        List<WorkshopDescriptor> matchingWorkshops = new ArrayList<>();

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
    private List<List<WorkshopDescriptor>> getMaximalSet(List<WorkshopDescriptor> matchingWorkshops){
        int length = matchingWorkshops.size();
        List<List<WorkshopDescriptor>> maximalSetsList = new ArrayList<>();
        List<WorkshopDescriptor>[] maximalSetsArray = new List[length];
        int window;//Time that students need to change rooms
        int maxim;
        int numberOfWorkshops;
        List<WorkshopDescriptor> maximalSet = new ArrayList<>();
        List<WorkshopDescriptor> workshopsSet;


        maximalSetsArray[length-1] = new ArrayList<>();
        maximalSetsArray[length-1].add(matchingWorkshops.get(length-1));

        for (int i = 0; i < length-1; i++){
            maximalSetsArray[i] = new ArrayList<>();
        }

        maxim = 0;
        for (int i = length-2; i>= 0; i--) {
            numberOfWorkshops = 0;
            for (int j = i + 1; j < length; j++) {
                if (matchingWorkshops.get(j).getRoom().equals(matchingWorkshops.get(i).getRoom())) {
                    window = 0;
                } else {
                    window = 10;
                }

                if ((TimeHelper.convertTimeToInteger(matchingWorkshops.get(j).getTime())
                        >= TimeHelper.convertTimeToInteger(matchingWorkshops.get(i).getTime()) + matchingWorkshops.get(i).getDuration() + window)
                        && (maximalSetsArray[j].size() > numberOfWorkshops)) {
                    numberOfWorkshops = maximalSetsArray[j].size();

                    maximalSetsArray[i].addAll(maximalSetsArray[j]);
                }
            }
            maximalSetsArray[i].add(matchingWorkshops.get(i));
        }
        numberOfWorkshops = 0;

        for (int i = 0; i < length; i++){
            if (maximalSetsArray[i].size() > numberOfWorkshops){
                maximalSet = maximalSetsArray[i];
                numberOfWorkshops = maximalSetsArray[i].size();
            }
            maxim = numberOfWorkshops;
        }

        for (int i = 0; i < length; i++){
            if (maximalSetsArray[i].size() == maxim){
                maximalSetsList.add(maximalSetsArray[i]);
            }
        }

        return maximalSetsList;
    }
}
