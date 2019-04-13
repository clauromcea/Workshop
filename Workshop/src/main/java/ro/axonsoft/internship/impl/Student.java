package ro.axonsoft.internship.impl;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String startTime;
    private String endTime;
    private List<String> disciplineList= new ArrayList<String>();

    public Student(String name, String startTime, String endTime, List<String> disciplineList) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<String> disciplineList) {
        this.disciplineList = disciplineList;
    }
}
