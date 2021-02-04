import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split("[,\n]");
        int sum = 0;
        List<String> negatives = new ArrayList<>();
        for (String number: numbers) {
            if (Integer.parseInt(number) < 0) {
                negatives.add(number);
            }
            sum += Integer.parseInt(number);
        }

        if (!negatives.isEmpty()) {
            String message = "Negatives: ";
            message += String.join(" ", negatives);
            throw new NegativeNumberException(message);
        }
        return sum;
    }
}
