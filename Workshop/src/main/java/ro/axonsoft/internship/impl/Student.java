package ro.axonsoft.internship.impl;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String lastName;
    private String firstName;
    private String startTime;
    private String endTime;
    private List<String> disciplineList= new ArrayList<String>();

    public Student(String lastName, String firstName, String startTime, String endTime, List<String> disciplineList) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.disciplineList = disciplineList;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
