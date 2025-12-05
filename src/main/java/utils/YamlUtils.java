package utils;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class YamlUtils {

    private static Map<String, Object> yamlMap;

    static {
        try {
            String environment = PropertiesUtils.get("environment");
            String fileName = "env-" + environment + ".yaml";

            InputStream input = YamlUtils.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (input == null) {
                throw new RuntimeException("Arquivo YAML não encontrado: " + fileName);
            }

            Yaml yaml = new Yaml();
            yamlMap = yaml.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar YAML", e);
        }
    }

    public static String get(String path) {
        String[] keys = path.split("\\.");
        Object result = yamlMap;

        for (String key : keys) {
            result = ((Map<String, Object>) result).get(key);
        }

        return result.toString();
    }
}