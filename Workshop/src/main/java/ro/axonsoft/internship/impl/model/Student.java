package ro.axonsoft.internship.impl.model;

import ro.axonsoft.internship.api.StudentDescriptor;

import java.util.ArrayList;
import java.util.List;

public class Student implements StudentDescriptor {
    private String name;
    private TimeInfo startTime;
    private TimeInfo endTime;
    private List<String> disciplineList= new ArrayList<String>();

    public Student(String name, TimeInfo startTime, TimeInfo endTime, List<String> disciplineList) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.disciplineList = disciplineList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeInfo getStartTime() {
        return startTime;
    }

    public void setStartTime(TimeInfo startTime) {
        this.startTime = startTime;
    }

    public TimeInfo getEndTime() {
        return endTime;
    }

    public void setEndTime(TimeInfo endTime) {
        this.endTime = endTime;
    }

    public List<String> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<String> disciplineList) {
        this.disciplineList = disciplineList;
    }
}
