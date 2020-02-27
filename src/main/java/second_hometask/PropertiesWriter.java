package second_hometask;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.stream.Collectors;

public class PropertiesWriter {

    public static void writeIntoOutputFile(String path, Map<String, Integer> map) {
        SortedProperties properties = new SortedProperties();
        Map<String, String> propertiesMap = map.keySet().stream().collect(Collectors.toMap(k -> k, k -> map.get(k).toString()));
        properties.putAll(propertiesMap);
        try (Writer output = new FileWriter(path)) {
            properties.store(output, null);
        } catch (IOException e) {
            throw new PropertiesWriterException("Cannot write properties in file " + path + ". ", e);
        }
    }

}

