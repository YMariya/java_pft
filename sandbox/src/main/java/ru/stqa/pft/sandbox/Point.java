package ru.stqa.pft.sandbox;

public class Point {
    int x;
    int у;

    Point(int х, int y) {
        this.x = х;
        this.у = y;
    }

    double distance(int х, int у) {
        int dx = this.x - х;
        int dy = this.у - у;
        return Math.sqrt(dx * dx + dy * dy);
    }

    double distance(Point p) {
        return distance(p.x, p.у);
    }


    public static void main(String[] args) {
        Point p1 = new Point(15, 0);
        Point p2 = new Point(30, 13);

        System.out.println("Расстояние между точками = " + p1.distance(p2));

    }
}


