package exercise;

// BEGIN
class App {
    public static void printSquare(Circle circle) {
        try {
            System.out.println((int) (circle.getSquare() + 1));
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
