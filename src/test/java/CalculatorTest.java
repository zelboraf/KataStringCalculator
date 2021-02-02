import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldReturnZeroWhenEmptyString() {
        int result = calculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void shouldReturnNumberWhenNumberGiven() {
        int result = calculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldAddTwoNumbersSeparatedByComma() {
        int result = calculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void shouldAddThreeNumbersSeparatedByComma() {
        int result = calculator.add("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void shouldAddNumbersSeparatedWithComaAndNewLine() {
        int result = calculator.add("1,2\n4");
        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldThrowExceptionWhenNegativeNumberProvided() {
        assertThrows(NegativeNumberException.class, () -> {
            calculator.add("-1");
        });
    }

    @Test
    void shouldIncludeAllNegativeNumbersInExceptionMessage() {
        NegativeNumberException exception = assertThrows(NegativeNumberException.class, () -> {
            calculator.add("-1,-2");
        });
        assertThat(exception.getMessage()).isEqualTo("Negatives: -1 -2");
    }
}