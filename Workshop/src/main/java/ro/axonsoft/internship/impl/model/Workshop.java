package ro.axonsoft.internship.impl.model;

import org.jetbrains.annotations.NotNull;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.impl.algorithm.TimeHelper;

public class Workshop implements WorkshopDescriptor, Comparable<Workshop> {

    private String name;
    private String discipline;
    private Integer room;
    private TimeInfo time;
    private Integer duration;


    public Workshop() {
    }

    public Workshop(String name, String discipline, Integer room, TimeInfo time, Integer duration) {
        this.name = name;
        this.discipline = discipline;
        this.room = room;
        this.time = time;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public TimeInfo getTime() {
        return time;
    }

    public void setTime(TimeInfo time) {
        this.time = time;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return  name + ", " +
                discipline + ", " +
                "room:" + room + ", " +
                time + ", " +
                duration + " min";
    }

    public int compareTo(@NotNull Workshop o) {
        return TimeHelper.convertTimeToInteger(this.time).compareTo(TimeHelper.convertTimeToInteger(o.getTime()));
    }
}
