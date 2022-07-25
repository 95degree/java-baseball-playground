import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeAll
    void init() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @MethodSource
    void calculate(String[] input, int expected) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected);
    }

    static List<Arguments> calculate(){
        return List.of(Arguments.arguments(new String[]{"1", "+", "3", "*", "4"},16),
                Arguments.arguments(new String[]{"0", "+", "4", "/", "4"},1),
                Arguments.arguments(new String[]{"2", "*", "3", "*", "4","/","4"},6),
                Arguments.arguments(new String[]{"11", "-", "3", "*", "10"},80));
    }
}
