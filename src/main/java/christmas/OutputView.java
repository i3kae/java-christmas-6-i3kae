package christmas;

import christmas.Messages.Main;
import java.text.DecimalFormat;

public class OutputView {
    private static final String TOTAL_PURCHASE_AMOUNT="<할인 전 총주문 금액>";
    private static final String AMOUNT_MESSAGE="원";
    private static final String THREE_NUMBER_FORMAT="###,###";
    private static final DecimalFormat decFormat = new DecimalFormat(THREE_NUMBER_FORMAT);
    public void printWelcome(){
        System.out.println(Main.WELCOME_MESSAGE.getMessage());
    }
    public void printTotalPurchaseAmount(Integer amount){
        System.out.println(TOTAL_PURCHASE_AMOUNT);
        System.out.println(decFormat.format(amount) + AMOUNT_MESSAGE);
    }
}
