package SVG;

import java.util.Collections;
import java.util.List;

public class RedCircle implements Shape {

    @Override
    public List<Tag> getTags() {

        Tag circle = new Tag("circle");
        circle.set("r", "5");
        circle.set("fill", "orangered");
        circle.set("stroke", "#660000");
        circle.set("stroke-width", "2");

        return Collections.singletonList(circle);
    }
}