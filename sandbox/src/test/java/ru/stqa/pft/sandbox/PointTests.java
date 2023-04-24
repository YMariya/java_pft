package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPointv1 (){

        Point p1 = new Point();
        Point p2 = new Point();
        p1.x1 = 4;
        p1.y1 = 19;
        p2.x2 = 5;
        p2.y2 = 8;
        Assert.assertEquals(p1.distance(p2),11.045361017187261);


    }

    @Test
    public void testPointv2 (){

        Point p1 = new Point();
        Point p2 = new Point();
        p1.x1 = 4;
        p1.y1 = 10;
        p2.x2 = 5;
        p2.y2 = 8;
        assert p1.distance(p2) == 2.23606797749979;


    }

}
