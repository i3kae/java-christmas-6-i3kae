package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.Messages.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private final Validator validator = new Validator();
    @Test
    @DisplayName("방문 날짜 검증 - 정상적인 문자열인 경우")
    void normalVisitDateTest(){
        assertThat(validator.visitDateChecker("1")).isEqualTo(false);
        assertThat(validator.visitDateChecker("15")).isEqualTo(false);
        assertThat(validator.visitDateChecker("31")).isEqualTo(false);
    }
    @Test
    @DisplayName("방문 날짜 검증 - 비어있는 문자열인 경우")
    void emptyVisitDateTest(){
        assertThat(validator.visitDateChecker("")).isEqualTo(true);
    }
    @Test
    @DisplayName("방문 날짜 검증 - 숫자로 이루어진 문자열이 아닌 경우")
    void nonNumericVisitDateTest(){
        assertThat(validator.visitDateChecker("  1")).isEqualTo(true);
        assertThat(validator.visitDateChecker("-1")).isEqualTo(true);
        assertThat(validator.visitDateChecker("우테코")).isEqualTo(true);
    }
    @Test
    @DisplayName("방문 날짜 검증 - 1 ~ 31 사이의 숫자가 아닌 경우")
    void notInVisitDateTest(){
        assertThat(validator.visitDateChecker("0")).isEqualTo(true);
        assertThat(validator.visitDateChecker("50")).isEqualTo(true);
    }
    @Test
    @DisplayName("세부 검증 함수 테스트 - 비어있는 문자열 검증 함수")
    void isEmptyTest() {
        assertThatThrownBy(() -> validator.isEmpty("", ErrorMessage.EMPTY_STR_ERROR))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("세부 검증 함수 테스트 - 숫자로 이루어진 문자열 검증 함수")
    void isNumericTest(){
        assertThatThrownBy(() -> validator.isNumeric("11!"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.isNumeric(" 3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.isNumeric("TEST"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
