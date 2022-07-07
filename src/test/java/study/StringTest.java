package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 분리")
    void split() {
        String string = "1,2";
        String[] actual = string.split(",");
        assertThat(actual).containsExactly("1", "2");
    }


    @Test
    @DisplayName("1,을 ,로 split 했을 때 1을 반환")
    void splitOneString() {
        String string = "1,";
        String[] actual = string.split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)를 index 1과 4로 subString 했을 때 1,2를 반환")
    void subString() {
        String string = "(1,2)";
        String actual = string.substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc에서 charAt으로 특정 위치는 문자를 가져온다.")
    void charAt() {
        String string = "abc";
        assertAll(
                () -> assertThat(string.charAt(0)).isEqualTo('a'),
                () -> assertThat(string.charAt(1)).isEqualTo('b'),
                () -> assertThat(string.charAt(2)).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("abc에서 charAt이 위치 값을 벗어나면 StringIndexOutOfBOundsException이 발생한다.")
    void charAtException() {
        String string = "abc";
        assertAll(
                () -> assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(
                        () -> string.charAt(6)),
                () -> assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(
                        () -> string.charAt(-1)
                )
        );
    }
}
