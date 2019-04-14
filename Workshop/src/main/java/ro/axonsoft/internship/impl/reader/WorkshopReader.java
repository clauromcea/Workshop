package ro.axonsoft.internship.impl.reader;

import ro.axonsoft.internship.api.Converter;
import ro.axonsoft.internship.api.Reader;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.impl.ReaderException;
import ro.axonsoft.internship.impl.model.TimeInfo;
import ro.axonsoft.internship.impl.model.Workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WorkshopReader implements Reader<Workshop> {
    private Converter<Workshop, String> converter;

    public WorkshopReader(Converter<Workshop, String> converter) {
        this.converter = converter;
    }

    @Override
    public List<Workshop> readFile(String filename) {
        List<Workshop> result = new ArrayList<>();
        Stream<String> lines = RawReader.readRawData(filename, getClass());
        lines.forEach((String s) -> {
            result.add(converter.convert(s));
        });

        lines.close();

        return result;
    }

    @Override
    public Workshop readLine(String line) throws ReaderException {
        return null;
    }

    public List<WorkshopDescriptor> loadWorkshops() {
        List<WorkshopDescriptor> workshopList = new ArrayList<WorkshopDescriptor>();

        workshopList.add(new Workshop("Instrumente neconventionale", "muzica", 12, new TimeInfo(13, 00), 90));
        workshopList.add(new Workshop("Povesti creative", "literatura", 25, new TimeInfo(8, 30), 50));
        workshopList.add(new Workshop("Pictura pe sticla", "pictura", 4, new TimeInfo(10, 15), 40));
        workshopList.add(new Workshop("Plantarea semintelor de flori", "natura", 26, new TimeInfo(15, 00), 45));
        workshopList.add(new Workshop("pictura pe ceramica", "pictura", 25, new TimeInfo(14, 00), 30));
        workshopList.add(new Workshop("Imprimare", "pictura", 4, new TimeInfo(15, 00), 30));
        workshopList.add(new Workshop("Construim casute pentru pasari", "natura", 18, new TimeInfo(12, 15), 90));
        workshopList.add(new Workshop("Pian", "muzica", 12, new TimeInfo(11, 00), 60));
        workshopList.add(new Workshop("Colaj", "pictura", 25, new TimeInfo(14, 30), 50));
        workshopList.add(new Workshop("Poezie", "lectura", 25, new TimeInfo(12, 15), 30));

        return workshopList;
    }
}
