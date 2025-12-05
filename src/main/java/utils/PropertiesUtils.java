package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = PropertiesUtils.class
                .getClassLoader()
                .getResourceAsStream("setup.properties")) {

            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("Arquivo setup.properties não encontrado!");
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar setup.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}