package SVG;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Settings {
    private static Settings instance = new Settings();
    private static Properties p = new Properties();
    private static int width;
    private static int height;
    private static String background;
    private static Random random;
    private static String draw;

    public static Settings getInstance() {
        try {
            p.load(new InputStreamReader(
                    new FileInputStream("svg.properties"),
                    StandardCharsets.UTF_8));

            width = Integer.parseInt(p.getProperty("width"));
            height = Integer.parseInt(p.getProperty("height"));
            background = p.getProperty("background");
            draw= p.getProperty("draw");

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

    public String getShapeDescription(String figureName) {
        return p.getProperty("shape." + figureName);
    }

    public Map<String, Integer> getShapesWithCount() {
        Map<String, Integer> oneShapeOneCount = new HashMap<>();

        //draw= "red_circle:150 small_square:100"

        String arrayOfShapesWithCounts[] = draw.split(" ");
        for (String shapeWithCount : arrayOfShapesWithCounts) {
            int delim = shapeWithCount.indexOf(":");
            String key = shapeWithCount.substring(0, delim);
            int value = Integer.parseInt(shapeWithCount.substring(delim + 1));
            oneShapeOneCount.put(key, value);
        }


        return oneShapeOneCount;
    }
}
