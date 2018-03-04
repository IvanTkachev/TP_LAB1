package shape.polygon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RightTriangle extends Polygon {
    public RightTriangle() {
    }

    public RightTriangle(Point cornerPoint, int frameWidth, Color frameColor, Color fillColor) {
        super(cornerPoint, frameWidth, frameColor, fillColor);
        setPoints(getRightPoints(cornerPoint));
    }

    public RightTriangle(Point theCenter, List<Point> points, int frameWidth, Color frameColor, Color fillColor) {
        super(theCenter, points, frameWidth, frameColor, fillColor);
    }

    private List<Point> getRightPoints(Point cornerPoint){
        Point theCenter = getLocation();
        List<Point> points = new ArrayList<>(3);
        Point upperLeft = new Point(theCenter.x, 2 * theCenter.y - cornerPoint.y);
        Point upperRight = new Point (cornerPoint.x, upperLeft.y);
        points.add(cornerPoint);
        points.add(upperRight);
        points.add(upperLeft);
        return points;
    }

    public void setCornerPoint(Point p) {
        setPoints(getRightPoints(p));
    }
}
