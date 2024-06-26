package GUI.zadanie_08_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiffLettWords {
    public static void main(String[] args) {
        //String book = "C:\\Users\\annar\\schultz_sklepy_cynamonowe_UTF8.txt";
        String book = "C:\\Users\\annar\\melville_moby_dick.txt";
        int minLen = 5; // ignore words shorter than minLen
        try (Stream<String> lines =
                     Files.lines(Paths.get(book)))
        {
            Map<Integer,List<String>> map = lines.flatMap(line -> Stream.of(line.split("[ .?!,:;\\-']"))).filter(word ->
                    word.length() >= minLen).map(String::toLowerCase).filter(word -> word.chars().distinct().count() == word.length())
                    .collect(Collectors.groupingBy(String::length));
                    /* one chain of stream operations */;

            // just printing
            List<Integer> lastTwo =
                    map.keySet().stream().sorted()
                            .collect(Collectors.toList());
            System.out.println("Two lists of the longest " +
                    "words with all letters different:");
            int len = lastTwo.get(lastTwo.size()-2);
            System.out.println("length " + len + ": " +
                    map.get(len));
            len = lastTwo.get(lastTwo.size()-1);
            System.out.println("length " + len + ": " +
                    map.get(len));
        } catch(IOException e) {
            System.out.println("Something wrong...");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
