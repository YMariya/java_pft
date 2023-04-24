package ru.stqa.pft.sandbox;

public class Point {

    public static double x1, y1, x2, y2;

    public Point (double x1, double y1) {
    }


    public static void main(String[] args) {
        Point p1 = new Point(1,3);
        Point p2 = new Point(x2,y2);
x2 = 4;
y2 = 5;



        System.out.println("Расстояние между точками = " + p1.distance(p2));

    }
      public double distance( Point p2) {
        double dx = this.x2 - x1;
        double dy = this.y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);

    }


}


