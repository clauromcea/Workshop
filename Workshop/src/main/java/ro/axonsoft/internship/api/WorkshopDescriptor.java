package ro.axonsoft.internship.api;

public interface WorkshopDescriptor{

    public String getName();

    public void setName(String name);

    public String getDiscipline();

    public void setDiscipline(String discipline);

    public Integer getRoom();

    public void setRoom(Integer room);

    public String getTime();

    public void setTime(String time);

    public Integer getDuration();

    public void setDuration(Integer duration);
}
