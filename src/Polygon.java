import java.util.Scanner;

public class Polygon {
    private int numberOfDots;
    private double[][] coordinates;
    private Dot[] polygon;
    private Dot[] convexPolygon;

    void setNumberOfDots(int number) {

        numberOfDots = number;
        System.out.println("Number of dots set: " + numberOfDots);
    }

    int getNumberOfDots() {
        return numberOfDots;
    }

    void setCoordinates(int numberOfDots) {
        double[][] coordinates = new double[numberOfDots][2];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numberOfDots; i++) {
            System.out.println("Enter coordinates for dot " + (i + 1) + ":");

            for (int j = 0; j < 2; j++) {
                System.out.print((j + 1) + " :");

                coordinates[i][j] = sc.nextDouble();
                sc.nextLine();
            }
            System.out.println("Dot " + (i + 1) + " is: (" + coordinates[i][0] + "," + coordinates[i][1] + ")");
        }
        sc.close();
        this.coordinates = coordinates;
    }

    double[][] getCoordinates() {
        return coordinates;
    }

    void setPolygon(double[][] coordinates) {
        Dot[] polygon = new Dot[numberOfDots];

        double value = 0;
        for (int i = 0; i < numberOfDots; i++) {
            polygon[i] = new Dot(coordinates[i][0], coordinates[i][1]);
        }
        for (int i = 0; i < numberOfDots; i++) {
            if (i == 0) {
                value = Dot.ProductOfTwoVectors(polygon[numberOfDots - 1], polygon[0], polygon[1]);
                if (value > 0) {
                    polygon[i].setPositive(true);
                    System.out.println("Polygon: dot added: " + i + ": x: " + polygon[i].getX() + ", y: " + polygon[i].getY() + ", is Positive: " + polygon[i].isPositive());
                } else {
                    polygon[i].setPositive(false);
                    System.out.println("Polygon: dot added: " + i + ": x: " + polygon[i].getX() + ", y: " + polygon[i].getY() + ", is Positive: " + polygon[i].isPositive());
                }
            } else if (i == numberOfDots - 1) {
                value = Dot.ProductOfTwoVectors(polygon[numberOfDots - 2], polygon[numberOfDots - 1], polygon[0]);
                if (value > 0) {
                    polygon[i].setPositive(true);
                    System.out.println("Polygon: dot added: " + i + ": x: " + polygon[i].getX() + ", y: " + polygon[i].getY() + ", is Positive: " + polygon[i].isPositive());
                } else {
                    polygon[i].setPositive(false);
                    System.out.println("Polygon: dot added: " + i + ": x: " + polygon[i].getX() + ", y: " + polygon[i].getY() + ", is Positive: " + polygon[i].isPositive());
                }

            } else {
                value = Dot.ProductOfTwoVectors(polygon[i - 1], polygon[i], polygon[i + 1]);
                if (value > 0) {
                    polygon[i].setPositive(true);
                    System.out.println("Polygon: dot added: " + i + ": x: " + polygon[i].getX() + ", y: " + polygon[i].getY() + ", is Positive: " + polygon[i].isPositive());
                } else {
                    polygon[i].setPositive(false);
                    System.out.println("Polygon: dot added: " + i + ": x: " + polygon[i].getX() + ", y: " + polygon[i].getY() + ", is Positive: " + polygon[i].isPositive());
                }
            }
        }
        this.polygon = polygon;
    }

    Dot[] getPolygon() {
        return polygon;
    }

    void setConvexPolygon(Dot[] polygon) {
        int numberOfPositive = 0;
        int numberOfNegative = 0;
        for (int i = 0; i < polygon.length; i++) {
            if (polygon[i].isPositive() == true) {
                numberOfPositive += 1;
            } else if (polygon[i].isPositive() == false) {
                numberOfNegative += 1;
            }
        }
        if (numberOfNegative < numberOfPositive) {
            Dot[] convexPolygon = new Dot[numberOfDots - numberOfNegative];
            int j = 0;
            for (int i = 0; i < polygon.length; i++) {
                if (polygon[i].isPositive() == true) {
                    convexPolygon[j] = polygon[i];

                    System.out.println("Convex polygon: dot added: (" + convexPolygon[j].getX() + "," + convexPolygon[j].getY() + ")");
                    j++;
                }
            }
            this.convexPolygon = convexPolygon;
            numberOfDots -= numberOfNegative;
            System.out.println("Number of dots final: " + numberOfDots);
        } else if (numberOfNegative > numberOfPositive) {

            Dot[] convexPolygon = new Dot[numberOfDots - numberOfPositive];
            int j = 0;
            for (int i = 0; i < polygon.length; i++) {
                if (polygon[i].isPositive() == false) {
                    convexPolygon[j] = polygon[i];

                    System.out.println("Convex polygon: dot added: (" + convexPolygon[j].getX() + "," + convexPolygon[j].getY() + ")");
                    j++;
                }

            }
            this.convexPolygon = convexPolygon;
            this.numberOfDots -= numberOfPositive;
            System.out.println("Number of dots final: " + numberOfDots);
        } else {
            System.out.println("This is Star Polygon");
            int j = 0, k = 0;
            double perimeterPositive = 0;
            double perimeterNegative = 0;
            Dot[] polygonPositive = new Dot[numberOfDots - numberOfNegative];
            Dot[] polygonNegative = new Dot[numberOfDots - numberOfPositive];
            for (int i = 0; i < polygon.length; i++) {
                if (polygon[i].isPositive()) {
                    polygonPositive[j] = polygon[i];
                    System.out.println("Positive polygon: dot added: (" + polygonPositive[j].getX() + "," + polygonPositive[j].getY() + ")");
                    j++;
                } else {
                    polygonNegative[k] = polygon[i];
                    System.out.println("Negative polygon: dot added: (" + polygonNegative[k].getX() + "," + polygonNegative[k].getY() + ")");
                    k++;
                }
            }
            for (int i = 0; i < polygonPositive.length; i++) {
                if (i == polygonPositive.length - 1) {
                    perimeterPositive += LineSegment.segmentLength(polygonPositive[i], polygonPositive[0]);
                } else {
                    perimeterPositive += LineSegment.segmentLength(polygonPositive[i], polygonPositive[i + 1]);
                }
            }
            for (int i = 0; i < polygonNegative.length; i++) {
                if (i == polygonNegative.length - 1) {
                    perimeterNegative += LineSegment.segmentLength(polygonNegative[i], polygonNegative[0]);
                } else {
                    perimeterNegative += LineSegment.segmentLength(polygonNegative[i], polygonNegative[i + 1]);
                }
            }
            if (perimeterPositive < perimeterNegative) {
                this.convexPolygon = polygonPositive;
                this.numberOfDots -= numberOfNegative;
                System.out.println("Positive polygon is smaller, set as Convex Polygon");
                System.out.println("Number of dots final: " + numberOfDots);
            } else {
                this.convexPolygon = polygonNegative;
                this.numberOfDots -= numberOfPositive;
                System.out.println("Negative polygon is smaller, set as Convex Polygon");
                System.out.println("Number of dots changed: " + numberOfDots);
            }

        }
    }

    Dot[] getConvexPolygon() {
        return convexPolygon;
    }

    void setSegmentsOfPolygon(Dot[] convexPolygon) {
        LineSegment[] segmentsOfPolygon = new LineSegment[convexPolygon.length];
        for (int i = 0; i < segmentsOfPolygon.length; i++) {
            if (i == segmentsOfPolygon.length - 1) {
                segmentsOfPolygon[i] = new LineSegment(convexPolygon[i], convexPolygon[0]);
                System.out.println("Segment: " + (i+1) + " set");
            } else {
                segmentsOfPolygon[i] = new LineSegment(convexPolygon[i], convexPolygon[i + 1]);
                System.out.println("Segment: " + (i+1) + " set");
            }
        }
    }

}


