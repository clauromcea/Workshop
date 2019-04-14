package ro.axonsoft.internship.impl.convertor;

import ro.axonsoft.internship.api.Converter;
import ro.axonsoft.internship.impl.model.Student;
import ro.axonsoft.internship.impl.model.TimeInfo;

import java.util.ArrayList;
import java.util.List;

public class StudentConverter implements Converter<Student, String> {
    private TimeConverter timeConverter;

    public StudentConverter(TimeConverter timeConverter) {
        this.timeConverter = timeConverter;
    }

    @Override
    public Student convert(String s) {
        String[] data = s.split(";");

        String name = data[0];
        TimeInfo startTime = timeConverter.convert(data[1]);
        TimeInfo endTime = timeConverter.convert(data[2]);
        List<String> disciplinesList = new ArrayList<>();

        if ("".equals(data[3])){
            disciplinesList.add("all");
        }else {
            for (int i = 3; i < data.length - 1; i++) {
                disciplinesList.add(data[i].toLowerCase());
            }
        }

        return new Student(name, startTime, endTime, disciplinesList);
    }
}
