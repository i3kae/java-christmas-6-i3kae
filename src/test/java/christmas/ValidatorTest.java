package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.Messages.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
    private final Validator validator = new Validator();
    @Test
    @DisplayName("방문 날짜 검증 - 정상적인 문자열인 경우")
    @ValueSource(strings = {"1", "15", "31"})
    void normalVisitDateTest(String input){
        assertThat(validator.visitDateChecker(input)).isEqualTo(false);
    }
    @Test
    @DisplayName("방문 날짜 검증 - 비어있는 문자열인 경우")
    void emptyVisitDateTest(){
        assertThat(validator.visitDateChecker("")).isEqualTo(true);
    }
    @Test
    @DisplayName("방문 날짜 검증 - 숫자로 이루어진 문자열이 아닌 경우")
    @ValueSource(strings = {"  1", "-1", "우테코"})
    void nonNumericVisitDateTest(String input){
        assertThat(validator.visitDateChecker(input)).isEqualTo(true);
    }
    @Test
    @DisplayName("방문 날짜 검증 - 1 ~ 31 사이의 숫자가 아닌 경우")
    @ValueSource(strings = {"0", "50"})
    void notInVisitDateTest(String input){
        assertThat(validator.visitDateChecker(input)).isEqualTo(true);
    }
    @Test
    @DisplayName("세부 검증 함수 테스트 - 비어있는 문자열 검증 함수")
    void isEmptyTest() {
        assertThatThrownBy(() -> validator.isEmpty("", ErrorMessage.EMPTY_STR_ERROR))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("세부 검증 함수 테스트 - 숫자로 이루어진 문자열 검증 함수")
    @ValueSource(strings = {"11!", " 3", "TEST"})
    void isNumericTest(String input){
        assertThatThrownBy(() -> validator.isNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
