public class Point {

    public static void main(String[] args) {

        double p1 = 8;
        double p2 = 5;

        System.out.println("Расстояние между точками " + p1 + " и " + p2 + " равно " + distance(p1, p2));

    }

    public double p1;
    public double p2;

    public static double distance(double p1, double p2) {
        return p1 - p2;
    }
}
