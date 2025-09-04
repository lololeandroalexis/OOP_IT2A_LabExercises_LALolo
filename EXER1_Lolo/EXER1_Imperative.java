public class ImperativeExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;

        // step-by-step instructions
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("Sum = " + sum);
    }
}