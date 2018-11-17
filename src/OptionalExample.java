import java.util.Arrays;
import java.util.Optional;

public class OptionalExample {

    // Nie należy przyjmować Optional jako parametr metody.
    // Zamiast tego nalezy tylko zwracać Optional w momencie gdy chcemy zakomunikować, że ta meotda może nie zwrócić żadnej wartości

    public static void main(String[] args) {
        printListOfNumbersAsText();
    }

    private static void printListOfNumbersAsText() {
        Optional<String> numberAsText = convertDigitToText(2);
        Optional<String> numberAsText2 = convertDigitToText(5);

        Arrays.asList(numberAsText, numberAsText2).stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(OptionalExample::printNumberText);
    }

    // ktokolwiek będzie chciał użyć tej metody od teraz będzie świadomy że może ona nie zwrócić wartości
    private static Optional<String> convertDigitToText(int number) {
        switch (number) {
            case 5:
                return Optional.of("pięć");
            case 1:
                return Optional.of("jeden");
            default:
                return Optional.empty();
        }
    }

    private static void printNumberText(String numberText) {
        System.out.println(numberText);
    }
}