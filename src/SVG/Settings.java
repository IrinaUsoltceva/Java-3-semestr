package SVG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Settings {
    private static Settings instance = new Settings();
    private static Properties p = new Properties();

    public static Settings getInstance() {
        try {
            p.load(new InputStreamReader(
                    new FileInputStream("svg.properties"),
                    StandardCharsets.UTF_8
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public int getWidth() {
        return Integer.parseInt(p.getProperty("width"));
    }

    public int getHeight() {
        return Integer.parseInt(p.getProperty("height"));
    }

    public String getBackground() {
        return p.getProperty("background");
    }
}
