package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.Messages.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
    private static final String DISPLAY_PARAMETERIZED_TEST = "{displayName} - [\"{0}\"]";
    private final Validator validator = new Validator();
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("방문 날짜 검증 | 정상적인 문자열인 경우")
    @ValueSource(strings = {"1", "15", "31"})
    void normalVisitDateTest(String input){
        assertThat(validator.visitDateChecker(input)).isEqualTo(false);
    }
    @Test
    @DisplayName("방문 날짜 검증 | 비어있는 문자열인 경우")
    void emptyVisitDateTest(){
        assertThat(validator.visitDateChecker("")).isEqualTo(true);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("방문 날짜 검증 | 숫자로 이루어진 문자열이 아닌 경우")
    @ValueSource(strings = {"  1", "-1", "우테코"})
    void nonNumericVisitDateTest(String input){
        assertThat(validator.visitDateChecker(input)).isEqualTo(true);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("방문 날짜 검증 | 1 ~ 31 사이의 숫자가 아닌 경우")
    @ValueSource(strings = {"0", "50"})
    void notInVisitDateTest(String input){
        assertThat(validator.visitDateChecker(input)).isEqualTo(true);
    }
    @Test
    @DisplayName("세부 검증 함수 테스트 | 비어있는 문자열 검증 함수")
    void isEmptyTest() {
        assertThatThrownBy(() -> validator.isEmpty("", ErrorMessage.EMPTY_STR_ERROR))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("세부 검증 함수 테스트 | 숫자로 이루어진 문자열 검증 함수")
    @ValueSource(strings = {"11!", " 3", "TEST"})
    void isNumericTest(String input){
        assertThatThrownBy(() -> validator.isNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @ValueSource(strings = {"티본스테이크-3,양송이수프-4,초코케이크-2", "제로콜라-2,레드와인-1,바비큐립-4", "해산물파스타-2"})
    @DisplayName("구매 목록 검증 | 정상적인 문자열의 경우")
    void normalPurchaseMenusTest(String input){
        assertThat(validator.purchaseChecker(input)).isEqualTo(false);
    }
    @Test
    @DisplayName("구매 목록 검증 | 비어있는 문자열의 경우")
    void emptyInputPurchaseMenus(){
        assertThat(validator.purchaseChecker("")).isEqualTo(true);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("구매 목록 검증 | 잘못된 구분자의 경우")
    @ValueSource(strings = {",티본스테이크-4", "초코케이크-6,","양송이수프,10", ",", "-"})
    void illigalSplitInputPurchaseMenus(String input){
        assertThat(validator.purchaseChecker(input)).isEqualTo(true);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("구매 목록 검증 | 메뉴에 없는 메뉴인 경우")
    @ValueSource(strings = {"안심스테이크-6", "양송이수프-4,콜라-3", "티본스테이크-4,크리스마스-3"})
    void notInMenuInputPurchaseMenus(String input){
        assertThat(validator.purchaseChecker(input)).isEqualTo(true);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("구매 목록 검증 | 갯수에 숫자가 아닌 값이 들어온 경우")
    @ValueSource(strings = {"티본스테이크-!,양송이수프-3", "해산물파스타-^"})
    void nonNumricInputPurchaseMenus(String input){
        assertThat(validator.purchaseChecker(input)).isEqualTo(true);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("구매 목록 검증 | 메뉴의 총합이 20개가 넘어갈 경우")
    @ValueSource(strings = {"티본스테이크-30", "타파스-5,시저샐러드-8,아이스크림-4,레드와인-2,바비큐립-4"})
    void overSizeInputPurchaseMenus(String input){
        assertThat(validator.purchaseChecker(input)).isEqualTo(true);
    }
    @Test
    @DisplayName("구매 목록 검증 | 음료 메뉴만 구매한 경우")
    void onlyDrinkOrder(){
        assertThat(validator.purchaseChecker("제로콜라-5")).isEqualTo(true);
    }
    @Test
    @DisplayName("구매 목록 검증 | 갯수가 0인 메뉴를 주문한 경우")
    void zeroMenuCountOrderTest(){
        assertThat(validator.purchaseChecker("바비큐립-4,해산물파스타-0")).isEqualTo(true);
    }
}
