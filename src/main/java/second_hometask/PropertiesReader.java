package second_hometask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertiesReader {

    private static final Properties properties;

    static {
        Properties tempProps = new Properties();
        try {
            tempProps.load(new FileInputStream("java/input.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties = tempProps;
    }

    public static Map<String, Integer> retrievePropertiesIntoMap() {
        if (properties.keySet().stream().anyMatch(k -> properties.getProperty(String.valueOf(k)).equals(String.valueOf(k)))) {
            throw new KeyAndValueAreEqualException("Key and value are equal");
        }
        return properties.keySet().stream().collect(Collectors.toMap(
                k -> properties.getProperty(String.valueOf(k)),
                k -> Integer.valueOf(String.valueOf(k))));
    }
}