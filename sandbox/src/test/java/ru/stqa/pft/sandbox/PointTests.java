package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPointv1() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(20, 50);

        Assert.assertEquals(p1.distance(p2), 53.85164807134504);
    }


    @Test
    public void testPointv2() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(20, 50);

        assert p1.distance(p2) == 53.85164807134504;
    }
}
