package ro.axonsoft.internship.impl;

public class Workshop {

    private String name;
    private String discipline;
    private Integer room;
    private String time;
    private Integer duration;

    public Workshop(String name, String discipline, Integer room, String time, Integer duration) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
