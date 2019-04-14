package ro.axonsoft.internship.impl.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class RawReader {

    static Stream<String> readRawData(String filename, Class clazz) {
        try {
            Path path = null;
            try {
                path = Paths.get(clazz.getClassLoader()
                        .getResource(filename).toURI());
            } catch (URISyntaxException e) {
                return null;
            }

            return Files.lines(path);
        } catch (IOException e) {
            return null;
        }
    }
}
