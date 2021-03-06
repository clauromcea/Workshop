package ro.axonsoft.internship.impl.convertor;

import ro.axonsoft.internship.api.Converter;
import ro.axonsoft.internship.impl.model.TimeInfo;
import ro.axonsoft.internship.impl.model.Workshop;

public class WorkshopConverter implements Converter<Workshop, String> {
    public TimeConverter timeConvertor;

    public WorkshopConverter(TimeConverter timeConvertor) {
        this.timeConvertor = timeConvertor;
    }

    @Override
    public Workshop convert(String s) {
        String[] data = s.split(";");

        String name = data[0];
        String discipline = data[1];
        int room = Integer.parseInt(data[2]);
        TimeInfo time = timeConvertor.convert(data[3]);
        int duration = Integer.parseInt(data[4]);

        return new Workshop(name, discipline, room, time, duration);
    }
}
