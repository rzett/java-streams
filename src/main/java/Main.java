import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public Main() throws IOException {
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

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
         * List
         */
         // 7. Stream from List, filter and print
         List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
         people
         	.stream()
         	.map(String::toLowerCase)
         	.filter(x -> x.startsWith("a"))
         	.forEach(System.out::println);


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

        /**
         * External Data Sources
         */
        // 1. Read bands.txt, sort, filter for length > 13 and print result
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands
        	.sorted()
         	.filter(x -> x.length() > 13)
         	.forEach(System.out::println);
        bands.close();

         // 2. Filter bands.txt for "jit"
         List<String> bands2 = Files.lines(Paths.get("bands.txt"))
         	.filter(x -> x.contains("jit"))
         	.collect(Collectors.toList());
         bands2.forEach(x -> System.out.println(x));

         // 3. Stream rows from CSV file and count
         Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
         int rowCount = (int)rows1
         	.map(x -> x.split(","))
             .filter(x -> x.length == 3)
         	.count();
         System.out.println(rowCount + " rows.");
         rows1.close();

         // 4. Stream rows from CSV file, parse data from rows
         Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
         rows2
         	.map(x -> x.split(","))
             .filter(x -> x.length == 3)
         	.filter(x -> Integer.parseInt(x[1]) > 15)
         	.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
         rows2.close();

         // 5. Stream rows from CSV file, store fields in HashMap
         Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
         Map<String, Integer> map = new HashMap<>();
         map = rows3
         	.map(x -> x.split(","))
             .filter(x -> x.length == 3)
         	.filter(x -> Integer.parseInt(x[1]) > 15)
         	.collect(Collectors.toMap(
                 x -> x[0],
                 x -> Integer.parseInt(x[1])));
         rows3.close();
         for (String key : map.keySet()) {
         	System.out.println(key + "  " + map.get(key));
         }

        // 6. Stream rows from CSV file, filter for length, value and print
        Stream<String> rows4 = Files.lines(Paths.get("data.txt"));
        rows4
            .map(x -> x.split(","))
            .filter(x -> x.length == 3)
            .filter(x -> Double.parseDouble(x[2]) > 2.0)
            .forEach(x -> System.out.println(x[2]));
        rows4.close();

         // 7. .csv Streaming
         Stream<String> rows5 = Files.lines(Paths.get("book.csv"));
         rows5
         	.map(x -> x.split(","))
         	.filter(x -> x.length == 3)
         	.map(x -> x[2] = (x[2] + " addedPart"))
         	.forEach(System.out::println);
         rows5.close();

        // 8. XML Streaming
        File file = new File("messages.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement());
        System.out.println("Root element name: " + doc.getDocumentElement().getNodeName());
        System.out.println("Root element value: " + doc.getDocumentElement().getNodeValue());
        System.out.println("Root element type: " + doc.getDocumentElement().getNodeType());
        System.out.println("Root element id: " + doc.getDocumentElement().getAttribute("id"));
        System.out.println("Root element parent node name: " + doc.getDocumentElement().getParentNode().getNodeName());

        NodeList childList = doc.getDocumentElement().getElementsByTagName("message");
    }
}
