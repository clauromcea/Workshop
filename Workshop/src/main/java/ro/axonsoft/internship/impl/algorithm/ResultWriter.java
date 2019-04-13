package ro.axonsoft.internship.impl.algorithm;

import ro.axonsoft.internship.api.SearchResult;
import ro.axonsoft.internship.api.Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ResultWriter implements Writer {
    /**
     * Writes the result information for each student
     */
    public void writeResult(List<SearchResult> results) throws IOException {
        FileWriter fileWriter;
        SearchResult result;
        Iterator<SearchResult> iteratorResults = results.iterator();

        while(iteratorResults.hasNext()){
            result = iteratorResults.next();

            fileWriter = new FileWriter(result.getStudentName()+".txt");
            fileWriter.write(result.toString());
            fileWriter.close();
        }
    }
}
