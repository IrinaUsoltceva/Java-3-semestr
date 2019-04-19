package SVG;

import java.util.Collections;
import java.util.List;

public class RedCircle implements Shape {

    private List<Tag> tagList;

    public RedCircle() {
        Tag circle = new Tag("circle");
        circle.set("r", "5");
        circle.set("fill", "orangered");
        circle.set("stroke", "crimson");
        circle.set("stroke-width", "2");

        tagList = Collections.singletonList(circle);
    }

    @Override
    public List<Tag> getTags() {
        return tagList;
    }
}