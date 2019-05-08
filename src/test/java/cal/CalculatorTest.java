package cal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    StringCalculator cal;

    @BeforeEach
    void setUp() {
        cal = new StringCalculator();

    }

    @Test
    void 유효하지_않은_값() {
        assertThrows(IllegalArgumentException.class, () -> {
           cal.calculate("2");
        });
    }

    @Test
    void 예외처리() {
        assertThat(Validator.checkFormat("+ 3 + 3")).isEqualTo(false);
        assertThat(Validator.checkFormat("10 + * 5")).isEqualTo(false);
        assertThat(Validator.checkFormat("10 ^ 2")).isEqualTo(false);
        assertThat(Validator.checkFormat("2")).isEqualTo(false);
        assertThat(Validator.checkFormat("10 + 2 / 0")).isEqualTo(false);
    }

    @Test
    void 덧셈() {
        int result = cal.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        int result = cal.calculate("3 - 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        int result = cal.calculate("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        int result = cal.calculate("4 / 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 복합_계산() {
        assertThat(cal.calculate("5 * 2 + 2")).isEqualTo(12);
        assertThat(cal.calculate("12 + 3 * 2")).isEqualTo(30);
        assertThat(cal.calculate("100 / 25 + 5")).isEqualTo(9);
    }

    @AfterEach
    void tearDown() {
        cal = null;
    }
}
