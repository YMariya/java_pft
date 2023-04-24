package ru.stqa.pft.sandbox;

public class Point {

    public static double x1, y1, x2, y2;



    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();

        p1.x1 = 4;
        p1.y1 = 10;
        p2.x2 = 5;
        p2.y2 = 8;


        System.out.println("Расстояние между точками = " + p1.distance(p2));

    }
      public double distance( Point p2) {
        double dx = this.x2 - x1;
        double dy = this.y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);

    }


}


