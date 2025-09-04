import java.util.List;

public class EXER1_Declarative {
    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Alan", "Aaron");

        // declarative: say what we want, not how
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);
    }
}