package ro.axonsoft.internship.api;

import ro.axonsoft.internship.impl.model.TimeInfo;

import java.util.List;

public interface StudentDescriptor {

    String getName();

    public void setName(String name);

    public TimeInfo getStartTime();

    public void setStartTime(TimeInfo startTime);

    public TimeInfo getEndTime();

    public void setEndTime(TimeInfo endTime);

    public List<String> getDisciplineList();

    public void setDisciplineList(List<String> disciplineList);

}
