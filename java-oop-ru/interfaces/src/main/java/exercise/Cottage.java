package exercise;

// BEGIN
class Cottage implements Home {
private double area;
private int floorCount;

public Cottage(double area, int floorCount) {
    this.area = area;
    this.floorCount = floorCount;
}

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        return Integer.signum((int) (this.getArea() - another.getArea()));
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
