package baseball.InputTest;

import baseball.validate.InputNumValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputNumValidatorTest {
    @DisplayName("3자리 숫자인지 확인")
    @Test
    //예외가 제대로 발생하는지 확인해야 한다. => assertThatThrownBy
    void validateLength(){
        assertThatThrownBy(()-> InputNumValidator.validateLength("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 숫자여야 합니다.");
    }

    @DisplayName("중복되는 값들인지 확인")
    @Test
    void ifDuplite(){
        assertThatThrownBy(()-> InputNumValidator.ifDuplite("332"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값들은 중복되지 않아야 합니다.");
    }

    @DisplayName("1~9범위의 숫자인지 확인")
    @Test
    void validateNumericAndRange(){
        assertThatThrownBy(()-> InputNumValidator.validateNumericAndRange("076"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9범위의 숫자여야 합니다.");
    }




}
