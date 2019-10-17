package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
    private Properties properties;
    private final String propertyFilePath = "src/test/resources/Config.properties";


    public FileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new java.io.FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}