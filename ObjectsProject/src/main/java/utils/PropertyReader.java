package utils;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;
    private static String fileName = "data.properties";

    static {
        properties = new Properties();
        InputStream fileStream = null;
        try {
            fileStream = new FileInputStream(Objects.requireNonNull
                    (PropertyReader.class.getClassLoader().getResource(fileName)).getPath());
            properties.load(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileStream != null) {
                try {
                    fileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }
}
