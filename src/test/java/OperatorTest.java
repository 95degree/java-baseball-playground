import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @ParameterizedTest
    @DisplayName("사칙연산 기호를 통해 올바른 Operator를 찾아온다")
    @MethodSource
    void findBySymbol(String symbol, Operator operator) {
        assertThat(Operator.findBySymbol(symbol)).isEqualTo(operator);
    }

    static List<Arguments> findBySymbol() {
        return List.of(Arguments.arguments("+", Operator.PLUS),
                Arguments.arguments("-", Operator.MINUS),
                Arguments.arguments("*", Operator.MULTIPLY),
                Arguments.arguments("/", Operator.DIVIDE));
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닐경우 IllegalArgumentException를 발생한다.")
    @ValueSource(strings = {"더하기", "123", "--", "~", ""})
    void checkCorrectOperator(String symbol) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.findBySymbol(symbol));
    }

    @ParameterizedTest
    @MethodSource
    void operatePlus(int left, int right, int expected) {
        assertThat(Operator.PLUS.operate(left, right)).isEqualTo(expected);
    }

    static List<Arguments> operatePlus() {
        return List.of(Arguments.arguments(1, 2, 3),
                Arguments.arguments(100, 2, 102),
                Arguments.arguments(-1, 2, 1),
                Arguments.arguments(-100, 2, -98));
    }

    @ParameterizedTest
    @MethodSource
    void operateMinus(int left, int right, int expected) {
        assertThat(Operator.MINUS.operate(left, right)).isEqualTo(expected);
    }

    static List<Arguments> operateMinus() {
        return List.of(Arguments.arguments(1, 2, -1),
                Arguments.arguments(100, 2, 98),
                Arguments.arguments(-1, 2, -3),
                Arguments.arguments(-100, 2, -102));
    }

    @ParameterizedTest
    @MethodSource
    void operateMultiply(int left, int right, int expected) {
        assertThat(Operator.MULTIPLY.operate(left, right)).isEqualTo(expected);
    }

    static List<Arguments> operateMultiply() {
        return List.of(Arguments.arguments(1, 2, 2),
                Arguments.arguments(100, 2, 200),
                Arguments.arguments(-1, 2, -2),
                Arguments.arguments(-100, 2, -200));
    }

    @ParameterizedTest
    @MethodSource
    void operateDivide(int left, int right, int expected) {
        assertThat(Operator.DIVIDE.operate(left, right)).isEqualTo(expected);
    }

    static List<Arguments> operateDivide() {
        return List.of(Arguments.arguments(1, 2, 0),
                Arguments.arguments(100, 2, 50),
                Arguments.arguments(-1, 2, 0),
                Arguments.arguments(-100, 2, -50));
    }
}
