package ro.axonsoft.internship.api;

import ro.axonsoft.internship.impl.model.TimeInfo;

import java.util.Collections;

public interface WorkshopDescriptor extends Comparable<WorkshopDescriptor> {

    public String getName();

    public void setName(String name);

    public String getDiscipline();

    public void setDiscipline(String discipline);

    public Integer getRoom();

    public void setRoom(Integer room);

    public TimeInfo getTime();

    public void setTime(TimeInfo time);

    public Integer getDuration();

    public void setDuration(Integer duration);
}
