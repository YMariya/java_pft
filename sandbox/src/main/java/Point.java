public class Point {
    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public double dis1(double x1, double y1) {
        this.x1 = x1;
        this.y1 = y1;
        return this.x1 + this.y1;
    }
    public double dis2(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;
        return this.x2 + this.y2;
    }
    public double distance(Point dis1, Point dis2){
        double d = Math.sqrt((dis2.x2 - dis1.x1) * (dis2.x2 - dis1.x1) + (dis2.y2 - dis1.y1) * (dis2.y2 * dis1.y1));
        return d;
    }
}
