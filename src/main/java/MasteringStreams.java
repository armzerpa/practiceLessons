import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MasteringStreams {
    record Car(String type, String make, String model, Integer engineCapacity) {}

    public static List<Car> filterCarsByType(List<Car> cars, String type) {
        List<Car> filterArray = cars.stream().filter(car -> car.type.equals(type)).toList();
        return filterArray;
    }

    public static List<String> mapTypeFromList(List<Car> cars) {
        List<String> list = cars.stream().map(car -> car.type).toList();
        return list;
    }

    public static List<String> flatMapTypeFromList(List<Car> cars) {
        List<String> list = cars.stream().flatMap(car -> Stream.of(car.type, car.make)).toList();
        return list;
    }
    public static void main(String[] args) {
        System.out.println("streams master class");

        List<Car> cars = List.of(
                new Car("sedan", "BMW", "530", 1998),
                new Car("sedan", "audi", "A5", 1998),
                new Car("sedan", "Mercedes", "E-Class", 2500),
                new Car("hatchback", "Skoda", "Octavia", 1600),
                new Car("hatchback", "Toyota", "Type-R", 1450)
        );

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 10));

        List<Car> sedanCars = filterCarsByType(cars, "sedan");
        List<String> result = flatMapTypeFromList(cars);
        System.out.println(result);

        Map<Boolean, List<Car>> partionedCars = cars.stream().collect(Collectors.partitioningBy(car -> car.type.equals("sedan")));
        System.out.println(partionedCars);

        Map<String, Map<String, Integer>> groupedCars = cars.stream().collect(Collectors.groupingBy(
                Car::type,
                Collectors.toMap(Car::make, Car::engineCapacity)
        ));
        System.out.println(groupedCars);
    }
}

