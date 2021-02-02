public class Calculator {
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",|\n");
        int sum = 0;
        for (String number: numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new NegativeNumberException();
            }
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
