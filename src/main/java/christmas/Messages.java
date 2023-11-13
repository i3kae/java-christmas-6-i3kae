package christmas;

public class Messages {
    public enum Main{
        WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
        VISIT_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        ORDER_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        private final String message;
        Main(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }

    public enum ErrorMessage{
        SPLIT_ERROR("[ERROR] 문자열의 구분이 비정상적입니다."),
        EMPTY_STR_ERROR("[ERROR] 비어있는 문자열이 들어왔습니다.."),
        EMPTY_REGEX_ERROR("[ERROR] 비어있는 구분자가 들어왔습니다."),
        NON_NUMERIC("[ERROR] 숫자가 아닌 값이 들어왔습니다."),
        NOT_IN_MENULIST("[ERROR] 메뉴 목록에 포함되어 있지 않은 메뉴입니다."),
        NON_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해주세요."),
        INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        private final String message;
        ErrorMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return message;
        }
    }
}
