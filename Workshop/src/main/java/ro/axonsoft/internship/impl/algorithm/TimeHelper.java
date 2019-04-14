package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.impl.model.TimeInfo;

public class TimeHelper {

    public static Integer convertTimeToInteger(TimeInfo time){
        return time.getHour()*60 + time.getMinute();
    }
}
