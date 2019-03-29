package SVG;

import java.util.HashMap;
import java.util.Map;

public class Tag {
    private Map<String, String> m = new HashMap<>();
    private String type;

    public Tag(String type) {
        this.type = type;
    }

    public void set(String key, String value) {
        m.put(key, value);
    }

    public Map<String, String> getM() {
        return m;
    }

    public String getType() {
        return type;
    }

    /*2. Класс Tag - это описание одного тега

    ```
        Tag rect1 = new Tag("rect");
        rect1.set("x", "200");
        rect1.set("y", "200");
        rect1.set("width", "10");
        rect1.set("height", "20");
        rect1.set("style", "stroke:#ff0000; fill: #0000ff");
    ```*/
}