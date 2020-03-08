import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * General
         */
        // 1. Print integer stream
        IntStream
                .range(1, 10)
                .forEach(System.out::print);

        // 2. Print integer stream with lambda expression
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.print(x));

        // 3. Sum integer stream
        System.out.println(
                IntStream
                        .range(1, 10)
                        .sum());

        // 4. Get first entry from sorted string stream
        Stream.of("Ava", "Serdo", "Banjo")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        /**
         * Lists
         */

        /**
         * Map
         */
        // 1. Print your environment variables
        System.getenv().entrySet().stream().
                forEach(e-> System.out.println(e));

        /**
         * Arrays
         */
        // 1. Stream from string array, sorted, filtered and printed
        String[] names1 = {"Alice", "Anastasia", "Kamil", "Bernd", "Samantha", "Amanda", "Hans", "Jane", "Kevin", "Bart"};
        Arrays.stream(names1)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        // 2. Average of Square of an int array
        int[] numbers = {2,4,6,8,10};
        Arrays.stream(numbers)
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        // 3. Concat strings
        String[] names2 = {"Alice", "Anastasia", "Kamil", "Bernd", "Samantha", "Amanda", "Hans", "Jane", "Kevin", "Bart"};
        Arrays.stream(names2)
                .map(x -> x.concat(" Added Part"))
                .forEach(System.out::println);

        // 4. Squash two-dimensional arrays into one list
        String[][] names = {{"Alice", "Anastasia", "Kamil", "Bernd", "Samantha", "Amanda", "Hans", "Jane", "Kevin", "Bart"},
                            {"Jennifer","Akin" , "Kebal", "Bernie", "Sandra", "Jacob", "Siegfried", "Roy", "Joe", "John"},
                            {"Abraham","Hue" , "Ko", "Lenny", "Ranjid", "Alex", "Sandy", "Jules", "Sajib"}};
        List<String> list = Arrays.stream(names)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());
        System.out.print(list.toString());
    }
}
