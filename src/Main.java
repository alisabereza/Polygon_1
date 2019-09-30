import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the number of dots: ");
        Scanner in = new Scanner(System.in);
        Polygon polygon = new Polygon();
        polygon.setNumberOfDots(in.nextInt());
        polygon.setCoordinates(polygon.getNumberOfDots());
        polygon.setPolygon(polygon.getCoordinates());
        polygon.setConvexPolygon(polygon.getPolygon());
        polygon.setSegmentsOfPolygon(polygon.getConvexPolygon());
        in.close();

    }
}
