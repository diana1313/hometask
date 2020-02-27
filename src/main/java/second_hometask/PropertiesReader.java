package second_hometask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertiesReader {

    private PropertiesReader() {
    }

    public static Properties getPropertyFile(String propertyPath) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertyPath));
        } catch (IOException e) {
            throw new PropertiesReaderException("Cannot load properties file " + propertyPath + ". ", e);
        }
        return properties;
    }
    
    public static Map<String, Integer> retrievePropertiesIntoMap(String path) {
        List<Integer> keys = getPropertyFile(path).keySet().stream().map(Object::toString)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        if (keys.stream().anyMatch(k -> getPropertyFile(path).getProperty(String.valueOf(k)).equals(String.valueOf(k)))) {
            throw new KeyAndValueAreEquelExeption("Key and value are equal");
        }
        return keys.stream().collect(Collectors.toMap(k -> getPropertyFile(path).getProperty(String.valueOf(k)), k -> k));
    }
}