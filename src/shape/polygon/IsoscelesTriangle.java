package shape.polygon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IsoscelesTriangle extends Polygon {

    private boolean isRotating = false;

    public IsoscelesTriangle() {
    }

    public IsoscelesTriangle(Point theCenter, int frameWidth, Color frameColor, Color fillColor) {
        super(theCenter, frameWidth, frameColor, fillColor);
    }

    public IsoscelesTriangle(Point theCenter, List<Point> points, int frameWidth, Color frameColor, Color fillColor) {
        super(theCenter, points, frameWidth, frameColor, fillColor);
    }

    public IsoscelesTriangle(Point theCenter, Point pointOnCircle, int frameWidth, Color frameColor, Color fillColor) {
        super(theCenter, frameWidth, frameColor, fillColor);
        setPoints(getPolygonPoints(theCenter, pointOnCircle));
    }

    public boolean isRotating() {
        return isRotating;
    }

    public void setRotating(boolean rotating) {
        isRotating = rotating;
    }

    private List<Point> getPolygonPoints(Point theCenter, Point pointOnCircle) {
        List<Point> points = new ArrayList<>(4);
        double radius = Math.sqrt(Math.pow((pointOnCircle.x) - theCenter.x, 2) + Math.pow(pointOnCircle.y - theCenter.y, 2));
        double z;
        double angle = 360.0 / 3;
        if (isRotating) {
            z = Math.asin((theCenter.y - pointOnCircle.y) / radius) * 180 / Math.PI;
            if (pointOnCircle.x < theCenter.x)
                z = 180.0 - z;
        } else {

            if (3 % 2 != 0)
                z = 90;
            else
                z = 90 - angle / 2;
        }
        for (int i = 0; i < 3; i++) {
            points.add(new Point(theCenter.x + (int) (Math.cos(z / 180 * Math.PI) * radius),
                    theCenter.y - (int) (Math.sin(z / 180 * Math.PI) * radius)));
            z = z + angle;
        }
        return points;
    }

    public void setPointOnCircle(Point p) {
        setPoints(getPolygonPoints(getLocation(), p));
    }
}
