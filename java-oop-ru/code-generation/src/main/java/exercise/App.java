package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
class App {
    public static void save(Path path, Car car) {
        String carString = car.serialize();
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileWriter file = new FileWriter(String.valueOf(path));
            file.write(carString);
            file.close();
            //mapper.writeValue(file, carString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path path) {
        try {
            String jsonString = new String(Files.readAllBytes(path));
            return Car.deserialize(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
