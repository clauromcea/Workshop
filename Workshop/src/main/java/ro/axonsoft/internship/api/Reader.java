package ro.axonsoft.internship.api;

import ro.axonsoft.internship.impl.ReaderException;

import java.util.List;

public interface Reader<Descriptor> {
    /**
     * Reads a file that contains information.
     * @param filename the name of the file.
     * @return a list of descriptions with the information parsed from the file
     */
    List<Descriptor> readFile(final String filename);
    /**
     * Reads a single line from the file.
     * @param line the line to read
     * @return a description
     */
    Descriptor readLine(final String line) throws ReaderException;
}
