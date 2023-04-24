package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPoint (){

        Point p1 = new Point();

        Assert.assertEquals(p1.distance(8),10.0);

    }

}
