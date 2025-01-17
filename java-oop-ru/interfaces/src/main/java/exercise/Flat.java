package exercise;

// BEGIN
class Flat implements Home {
private double area;
private double balconyArea;
private int floor;

public Flat(double area, double balconyArea, int floor) {
    this.area = area;
    this.balconyArea = balconyArea;
    this.floor = floor;
}

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        return Integer.signum((int) (this.getArea() - another.getArea()));
    }

    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + floor + " этаже";
    }
}
// END
