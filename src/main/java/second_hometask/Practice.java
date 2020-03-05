package second_hometask;

import java.util.Map;

public class Practice {
    public static void main(String[] args) {
        Map<String, Integer> map = PropertiesReader.retrievePropertiesIntoMap();
        PropertiesWriter.writeIntoOutputFile("src/main/output.properties", map);

    }
}
