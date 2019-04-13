package ro.axonsoft.internship.impl.reader;

import ro.axonsoft.internship.api.Reader;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.impl.entity.Workshop;

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

        workshopList.add(new Workshop("Instrumente neconventionale", "muzica", 12, "13:00", 90));
        workshopList.add(new Workshop("Povesti creative", "literatura", 25, "8:30", 50));
        workshopList.add(new Workshop("Pictura pe sticla", "pictura", 4, "10:15", 40));
        workshopList.add(new Workshop("Plantarea semintelor de flori", "natura", 26, "15:00", 45));
        workshopList.add(new Workshop("pictura pe ceramica", "pictura", 25, "14:00", 30));
        workshopList.add(new Workshop("Imprimare", "pictura", 4, "15:00", 30));
        workshopList.add(new Workshop("Construim casute pentru pasari", "natura", 18, "12:15",90));
        workshopList.add(new Workshop("Pian", "muzica", 12, "11:00",60));
        workshopList.add(new Workshop("Colaj","pictura",25,"14:30",50));
        workshopList.add(new Workshop("Poezie", "lectura", 25,"12:15",30));

        return workshopList;
    }
}
