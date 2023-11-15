package christmas;

import christmas.FoodMenu.MenuList;
import java.util.Map;

public class MainController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void eventPlannerStart(){
        Customer customer;
        Integer visitDate;
        Map<MenuList, Integer> purchaseMenus;
        outputView.printVisitDateAnnouncement();
        visitDate = inputView.readDate();
        outputView.printPurchaseMenuAnnouncement();
        purchaseMenus = inputView.readPurchaseMenu();
        outputView.printWelcome();
        customer = new Customer(visitDate, purchaseMenus);
        outputView.printEventPreview(customer);
    }
}
