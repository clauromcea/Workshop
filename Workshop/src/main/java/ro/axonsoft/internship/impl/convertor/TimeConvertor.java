package ro.axonsoft.internship.impl.convertor;

import ro.axonsoft.internship.api.Convertor;
import ro.axonsoft.internship.impl.model.TimeInfo;

public class TimeConvertor implements Convertor<TimeInfo, String> {

    @Override
    public TimeInfo convert(String string) {
        String[] hourAndMinute = string.split(":");

        return new TimeInfo(Integer.parseInt(hourAndMinute[0]), Integer.parseInt(hourAndMinute[1]));
    }
}
