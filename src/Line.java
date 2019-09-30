public class Line {
    // line: ax + by + c = 0
    private double a,b,c;

    Line(Dot dot1, Dot dot2) {
        this.a = dot2.getY()-dot1.getY();
        this.b = dot1.getX()-dot2.getX();
        this.c = dot2.getX()*dot1.getY()-dot1.getX()*dot2.getY();
    }

    void lineInfo () {
        System.out.println("Line is: " + a + "*x + "+ b + "*y + " + c + " = 0");
    }

}