import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoviesCSV {
    public static void main(String[] args) {
        List<String[]> movies = loadMovies();

        countMoviesInFile(movies);
        getMaxAndMinYear(movies);
        countNumberOfFilmsInEachMovieType(movies);
    }

    private static void countNumberOfFilmsInEachMovieType(List<String[]> movies) {
        Map<String, Long> movieTypesMap = movies.stream()
                .map(movie -> movie[2])
                .flatMap(type -> Arrays.stream(type.split("\\|"))) // otrzymuje kilka wartosci z 1 input
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // show sorted map
        movieTypesMap.entrySet().stream() // entrySet potrzebuje użyć stream na map
                .sorted(Map.Entry.comparingByValue()) // to tylko sortowanie
                .forEach(entry -> System.out.println("Gatunek: " + entry.getKey() + ", ilość: " + entry.getValue()));

        movieTypesMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> System.out.println("Najczęściej występujący: " + e.getKey() + " " + e.getValue()));
    }

    private static void getMaxAndMinYear(List<String[]> movies) {
        List<Integer> years = movies.stream()
                .map(movie -> movie[1])
                .map(title -> title.substring(title.length() - 5, title.length() - 1))
                .filter(yearText -> yearText.matches("[0-9]+"))
                .map(yearText -> Integer.parseInt(yearText))
                .collect(Collectors.toList());

        System.out.println("MAX: " + Collections.max(years) + " " + "MIN: " + Collections.min(years));
    }

    private static void countMoviesInFile(List<String[]> movies) {
        movies.size();
        System.out.println("Jest " + movies.size() + " filmów w pliku");
    }

    private static List<String[]> loadMovies() {
        Path sourcePath = Paths.get("movies.csv");

        List<String> lines = null;
        try {
            lines = Files.readAllLines(sourcePath);
        } catch (Exception e) {
            System.out.println("Błąd dostępu do pliku: " + sourcePath.getFileName());
        }

        // Parsowanie pliku CSV
        return lines.stream()
                .skip(1) // pomijamy nagłówek
                .map(MoviesCSV::parseCSV)
                .collect(Collectors.toList());
    }

    /**
     * Do parsowania pliku można użyć np. własnego kodu, wyrażeń regularnych lub pliku
     * W tej metodzie zostały użyte wyrażenia regularne
     */
    private static String[] parseCSV(String line) {
        String regex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        String[] movie = line.split(regex);
        String title = movie[1].trim();
        if (title.charAt(0) == '"' && title.charAt(title.length() - 1) == '"') {
            movie[1] = title.substring(1, title.length() - 1).trim();
        }
        return movie;
    }
}
