import java.util.Arrays;

public class FunctionalExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // functional style using streams
        int sum = Arrays.stream(numbers)
                        .filter(n -> n % 2 == 1) // keep odd numbers
                        .map(n -> n * n)         // square them
                        .sum();

        System.out.println("Sum of squares of odd numbers = " + sum);
    }
}