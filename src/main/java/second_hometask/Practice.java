package second_hometask;

import java.util.Map;

public class Practice {

    public static void main(String[] args) {
        Map<String, Integer> map = PropertiesReader.retrievePropertiesIntoMap("src/test/resources/input.properties");
        PropertiesWriter.writeIntoOutputFile("src/test/resources/output.properties", map);

    }

}
