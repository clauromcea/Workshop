package ro.axonsoft.internship.impl.model;

public class TimeInfo {
    private int hour;
    private int minute;

    public TimeInfo(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        String hour = "" + this.hour;
        String minute = "" + this.minute;
        if (this.hour < 10){
            hour = "0" + this.hour;
        }
        if (this.minute < 10){
            minute = "0" + this.minute;
        }
        return hour + ":" + minute;
    }
}
