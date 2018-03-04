package shape.polygon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IsoscelesTriangle extends Polygon {

    public IsoscelesTriangle() {
    }

    public IsoscelesTriangle(Point theCenter, int frameWidth, Color frameColor, Color fillColor) {
        super(theCenter, frameWidth, frameColor, fillColor);
    }

    public IsoscelesTriangle(Point theCenter, List<Point> points, int frameWidth, Color frameColor, Color fillColor) {
        super(theCenter, points, frameWidth, frameColor, fillColor);
    }

    public IsoscelesTriangle(Point theCenter, Point cornerPoint, int frameWidth, Color frameColor, Color fillColor) {
        super(theCenter, frameWidth, frameColor, fillColor);
        setPoints(getIsoscelesPoints(cornerPoint));
    }

    private List<Point> getIsoscelesPoints(Point cornerPoint) {
        Point theCenter = getLocation();
        List<Point> points = new ArrayList<>(3);
        Point upperLeft = new Point(2*theCenter.x-cornerPoint.x, 2*theCenter.y-cornerPoint.y);
        Point upperRight = new Point(3* cornerPoint.x - 2*theCenter.x,upperLeft.y);
        points.add(cornerPoint);
        points.add(upperRight);
        points.add(upperLeft);
        return points;
    }

    public void setCornerPoint(Point p) {
        setPoints(getIsoscelesPoints(p));
    }
}
