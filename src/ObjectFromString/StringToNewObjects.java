package ObjectFromString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToNewObjects {

    // ZADANIE: Wczytaj wartość text z pliku tekstowego

    public static void main(String[] args) {
        String text = "Kowalski, Jan, 1960 * Borówka, Piotr, 1991 * Grzybiarz, Andrzej, 1990 * Smith, John, 1967";
        createPersonList(text);
    }

    // 1. _Kowalski, Jan, 1960_ (z odstępami)
    // 2. z kazdej części tekstu do przecinka utwórz element tablicy tab[0] = Kowalski, tab[1] = Jan, tab[2] = 1960
    // 3. skorzystaj z metody createPerson do utworzenia obiektu (parsowanie ze String na int)
    // 4. zbierz wszystkie obiekty typu objectFromString.Person i zapisz jest w liście

    private static void createPersonList(String text) {
        List<Person> personList = Arrays.stream(text.split(" \\* "))
                .map(String::trim)                                     //1
                .map(personText -> personText.split(","))        //2
                .map(StringToNewObjects::createPerson)                 //3
                .collect(Collectors.toList());                         //4

        personList.forEach(System.out::println);
    }

    private static Person createPerson(String[] personTab) {
        String name = personTab[0];
        String surname = personTab[1].trim();
        // tutaj bardzo ważne żeby pozbyć się odstępów przy pomocy trim() w przeciwnym razie wystąpi NumberFormatException
        int birthYear = Integer.parseInt(personTab[2].trim());
        //String fullName = name + " " + surname;
        String fullName = new StringBuilder().append(name).append(" ").append(surname).toString();

        Person person = new Person(name, surname, birthYear);
        person.setFullName(fullName);
        return person;
    }
}

