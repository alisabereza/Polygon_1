public class LineSegment {
    private Dot dot1, dot2;

    LineSegment(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
    }

    Dot getDot1() {
        return dot1;
    }

    void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    Dot getDot2() {
        return dot2;
    }

    void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    static double segmentLength(Dot dot1, Dot dot2) {
        return Math.sqrt(Math.pow((dot2.getX() - dot1.getX()), 2) + Math.pow((dot2.getY() - dot1.getY()), 2));
    }
}