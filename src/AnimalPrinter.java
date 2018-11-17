import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalPrinter {

    public static void main(String[] args) {
        List<String> animals = Arrays.asList("cat", "dog", "mouse", " rat", "pig", "hamster ", "parrot");
        displayAnimals(animals);
        System.out.println();
        displayAnimalsUsingStream(animals);
    }

    private static void displayAnimals(List<String> animals) {
        // TODO wszystko pisane wielką literą (toUpperCase), usunąć odstępy (trim), odzielić przecinkami
        for (int i = 0; i < animals.size(); i++) {
            String animal = animals.get(i).toUpperCase().trim();
            if (i < animals.size() - 1) {
                animal = animal + ", ";
            }
            System.out.print(animal);
        }
    }

    private static void displayAnimalsUsingStream(List<String> animals) {
        System.out.println(animals.stream().map(e -> e.toUpperCase().trim()).collect(Collectors.joining(", ")));
    }
}
