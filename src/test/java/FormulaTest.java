import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FormulaTest {

    @ParameterizedTest
    @DisplayName("올바른 사칙연산 문자열을 넣어주면 숫자와 사칙연산기호로 분리한 문자열 배열을 가진다.")
    @MethodSource
    void getValue(String input, List<Integer> expected) {
        assertThat(new Formula(input).getValue()).isEqualTo(expected);
    }

    static List<Arguments> getValue() {
        return List.of(Arguments.arguments("1+3*4", List.of(1, 3, 4)),
                Arguments.arguments("0+4/4", List.of(0, 4, 4)),
                Arguments.arguments("2*3*4/4", List.of(2, 3, 4, 4)),
                Arguments.arguments("11-3*10", List.of(11, 3, 10)),
                Arguments.arguments("-1-3+5", List.of(1, 3, 5)));
    }
}
