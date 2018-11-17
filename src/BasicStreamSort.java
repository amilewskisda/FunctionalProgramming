import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicStreamSort {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Ala", "ma", "czarnego", "kota", "o", "imieniu", "Bonifacy");

        // wyswietl posortowana alfabetycznie liste wyrazow
        Collections.sort(words, (o1, o2) -> o1.compareTo(o2)); // w odwrotnej kolejnosci o2.compareTo(o1))
        words.stream().forEach(s -> System.out.println(s));

        // wyświetl tylko te wyrazy ktore skladaja sie z wiecej niz 3 znakow, policz je i wyswietl ich liczbe
/*        long count = words.stream()
                .filter(s -> s.length() > 3)
                .peek(System.out::println)
                .count();

        System.out.println(count);*/

/*        // wyswietl pisane wielka litera te wyrazy ktorych dlugosc jest wieksza niz 4
        words.stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 4)
                .forEach(s -> System.out.println(s));*/
    }
}