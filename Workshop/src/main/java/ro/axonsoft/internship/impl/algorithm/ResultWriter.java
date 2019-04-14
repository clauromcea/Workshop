package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.SearchResult;
import ro.axonsoft.internship.api.WorkshopDescriptor;
import ro.axonsoft.internship.api.Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ResultWriter implements Writer {
    /**
     * Writes the result information for each student
     */
    public void writeResult(List<SearchResult> results) {
        FileWriter fileWriter;
        SearchResult result;
        Iterator<SearchResult> iteratorResults = results.iterator();

        try {
            while (iteratorResults.hasNext()) {
                result = iteratorResults.next();

                fileWriter = new FileWriter("Results/"+result.getStudentName() + ".txt");

                writeWorkshopOnLine(fileWriter, result);
                fileWriter.close();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void writeWorkshopOnLine(FileWriter fileWriter, SearchResult result){
        Iterator<WorkshopDescriptor> iteratorWorksops = result.getWorkshops().iterator();

        try {
            fileWriter.write(result.getStudentName());
            while (iteratorWorksops.hasNext()) {
                fileWriter.write("\n" + iteratorWorksops.next().toString());
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
