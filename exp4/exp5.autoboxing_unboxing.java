import java.util.ArrayList;

public class SumUsingAutoboxing {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        
        // Autoboxing: Adding primitive integers to the ArrayList
        numbers.add(Integer.parseInt("10"));
        numbers.add(Integer.parseInt("20"));
        numbers.add(Integer.parseInt("30"));

        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing: Integer to int
        }

        System.out.println("Sum of integers: " + sum);
    }
}
