import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldReturnZeroWhenEmptyString() {
        // GIVEN

        // WHEN
        int result = calculator.add("");

        // THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldReturnNumberWhenNumberGiven() {
        // GIVEN

        // WHEN
        int result = calculator.add("1");

        // THEN
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldAddTwoNumbersSeparatedByComma() {
        // GIVEN

        // WHEN
        int result = calculator.add("1,2");

        // THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldAddThreeNumbersSeparatedByComma() {
        // GIVEN

        // WHEN
        int result = calculator.add("1,2,3");

        // THEN
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldAddNumbersSeparatedWithComaAndNewLine() {
        // GIVEN

        // WHEN
        int result = calculator.add("1,2\n4");

        // THEN
        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumberProvided() {
        // GIVEN

        // WHEN

        // THEN
        Assertions.assertThrows(NegativeNumberException.class, () -> {
            calculator.add("-1");
        });
    }

    @Test
    void shouldIncludeAllNegativeNumbersInExceptionMessage() {
        // GIVEN

        // WHEN
        NegativeNumberException exception = Assertions.assertThrows(NegativeNumberException.class, () -> {
            calculator.add("-1,-2");
        });

        // THEN
        assertThat(exception.getMessage()).isEqualTo("Negatives: -1 -2");
    }
}