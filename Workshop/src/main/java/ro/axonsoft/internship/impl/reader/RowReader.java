package ro.axonsoft.internship.impl.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class RowReader {

    static Stream<String> readRowData(String filename, Class clazz){
        try {
            Path path = null;
            try{
                path = Paths.get(clazz.getClassLoader().getResource(filename).toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            return Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
