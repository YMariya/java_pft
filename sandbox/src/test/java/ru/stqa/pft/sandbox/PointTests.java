package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPointv1 (){

        Point p1 = new Point(4,19);

        Point p2 = new Point(Point.x2,Point.y2);
        Point.x2 = 4;
        Point.y2 = 5;
        Assert.assertEquals(p1.distance(p2),11.045361017187261);


    }

    @Test
    public void testPointv2 (){

        Point p1 = new Point(1,5);
        Point p2 = new Point(3,9);
        assert p1.distance(p2) == 2.23606797749979;


    }

}
