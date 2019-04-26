package SVG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Settings {
    private static Settings instance = new Settings();
    private static Properties p = new Properties();
    private static int width;
    private static int height;
    private static String background;
    private static String randSeed;

    public static Settings getInstance() {
        try {
            p.load(new InputStreamReader(
                    new FileInputStream("svg.properties"),
                    StandardCharsets.UTF_8
            ));

            width = Integer.parseInt(p.getProperty("width"));
            height = Integer.parseInt(p.getProperty("height"));
            background = p.getProperty("background");
            randSeed = p.getProperty("rand_seed");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getBackground() {
        return background;
    }

    public long getRandSeed () {
        try {
            return Integer.parseInt(randSeed);
        } catch (Exception e) {
            return 0;
        }
    }
}
