package SVG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Random;

public class Settings {
    private static Settings instance = new Settings();
    private static Properties p = new Properties();
    private static int width;
    private static int height;
    private static String background;
    private static Random random;

    public static Settings getInstance() {
        try {
            p.load(new InputStreamReader(
                    new FileInputStream("svg.properties"),
                    StandardCharsets.UTF_8));

            width = Integer.parseInt(p.getProperty("width"));
            height = Integer.parseInt(p.getProperty("height"));
            background = p.getProperty("background");

            String randSeed = p.getProperty("rand_seed");
            if (randSeed.equals("auto"))
                random = new Random();
            else
                random = new Random(Long.parseLong(randSeed));

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

    public Random getRandomGenerator() {
        return random;
    }
}
