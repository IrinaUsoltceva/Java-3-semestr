package SVG;

import java.util.Collections;
import java.util.List;

public class SmallSquare implements Shape {


    private List<Tag> tagList;

    public SmallSquare() {
        Tag rect = new Tag("rect");
        rect.set("x", "-10");
        rect.set("y", "-10");
        rect.set("height", "10");
        rect.set("width", "10");
        rect.set("fill", "#00ffff");
        rect.set("stroke", "#004cff");
        rect.set("stroke-width", "2");

        tagList = Collections.singletonList(rect);
    }

    @Override
    public List<Tag> getTags() {
        return tagList;
    }
}
