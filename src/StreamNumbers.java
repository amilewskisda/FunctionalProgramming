import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamNumbers {
    public static void main(String[] args) {

        // utwórz listę liczb całkowitych przy pomocy strumieni w zakresie od 5 do 100 i tylko takich które są podzielne przez 3.
        // Pokaż na ekranie pierwsze 5 wyników podniesionych do potęgi 2. Nie możesz skorzystać z for ani while!

        List<Integer> numbers = Stream.iterate(0, x -> x + 1)
                .filter(x -> x > 5 && x < 100 && x % 3 == 0)
                .limit(5)
                .map(x -> (int) Math.pow(x, 2.0))
                .collect(Collectors.toList());

        numbers.forEach(System.out::println);
    }
}
