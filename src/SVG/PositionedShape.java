package SVG;

import java.util.ArrayList;
import java.util.List;

public class PositionedShape implements Shape{
    private Shape shape;
    private int x;
    private int y;

    public PositionedShape(Shape shape, int x, int y) {
        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    @Override
    public List<Tag> getTags() {
        List<Tag> tagList = new ArrayList<Tag>();

        Tag g = new Tag("g", TagType.OPEN);
        g.set("transform", "translate(" + x + ", " + y + ")");
        Tag gClose = new Tag("g", TagType.CLOSE);

        tagList.add(g);
        tagList.addAll(shape.getTags());
        tagList.add(gClose);

        return tagList;
    }
}
