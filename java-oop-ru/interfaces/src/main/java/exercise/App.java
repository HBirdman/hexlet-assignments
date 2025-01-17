package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        if (homes.isEmpty()) {
            return new ArrayList<>();
        }
        homes.sort(Comparator.comparing(Home::getArea));
        List<String> result = new ArrayList<>();
        for (var i = 0; i < n; i++) {
            result.add(homes.get(i).toString());
        }
        return result;
    }
}
// END
