package ro.axonsoft.internship.impl.reader;

import ro.axonsoft.internship.api.Reader;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.impl.model.TimeInfo;
import ro.axonsoft.internship.impl.model.Workshop;

import java.util.ArrayList;
import java.util.List;

public class WorkshopReader implements Reader<WorkshopDescriptor> {

    public List<WorkshopDescriptor> readFile(String filename) {
        return null;
    }

    public Workshop readLine(String line) {
        return null;
    }

    public List<WorkshopDescriptor> loadWorkshops(){
        List<WorkshopDescriptor> workshopList = new ArrayList<WorkshopDescriptor>();

        workshopList.add(new Workshop("Instrumente neconventionale", "muzica", 12, new TimeInfo(13, 00), 90));
        workshopList.add(new Workshop("Povesti creative", "literatura", 25, new TimeInfo(8, 30), 50));
        workshopList.add(new Workshop("Pictura pe sticla", "pictura", 4, new TimeInfo(10, 15), 40));
        workshopList.add(new Workshop("Plantarea semintelor de flori", "natura", 26, new TimeInfo(15, 00), 45));
        workshopList.add(new Workshop("pictura pe ceramica", "pictura", 25, new TimeInfo(14, 00), 30));
        workshopList.add(new Workshop("Imprimare", "pictura", 4, new TimeInfo(15, 00), 30));
        workshopList.add(new Workshop("Construim casute pentru pasari", "natura", 18, new TimeInfo(12, 15),90));
        workshopList.add(new Workshop("Pian", "muzica", 12, new TimeInfo(11, 00),60));
        workshopList.add(new Workshop("Colaj","pictura",25,new TimeInfo(14, 30),50));
        workshopList.add(new Workshop("Poezie", "lectura", 25,new TimeInfo(12, 15),30));

        return workshopList;
    }
}
