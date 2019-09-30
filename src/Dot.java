public class Dot {
    private double x, y;
    private boolean isPositive;

    Dot(double x, double y, boolean isPositive) {
        this.x = x;
        this.y = y;
        this.isPositive = isPositive;
    }

    void setPositive(boolean positive) {
        isPositive = positive;
    }

    boolean isPositive() {
        return isPositive;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static double ProductOfTwoVectors(Dot dot1, Dot dot2, Dot dot3) {
        double product = dot1.getX() * dot2.getY() + dot3.getX() * dot1.getY() + dot2.getX() * dot3.getY() - dot3.getX() * dot2.getY() - dot2.getX() * dot1.getY() - dot1.getX() * dot3.getY();
        return product;
    }
}
