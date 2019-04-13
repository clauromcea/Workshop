package ro.axonsoft.internship.api;

import java.util.List;

public interface StudentDescriptor {

    String getName();

    public void setName(String name);

    public String getStartTime();

    public void setStartTime(String startTime);

    public String getEndTime();

    public void setEndTime(String endTime);

    public List<String> getDisciplineList();

    public void setDisciplineList(List<String> disciplineList);

}
