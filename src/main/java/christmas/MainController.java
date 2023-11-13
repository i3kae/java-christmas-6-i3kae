package christmas;

public class MainController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void eventPlannerStart(){
        Customer customer;
        outputView.printWelcome();
        customer = new Customer(inputView.readDate(), inputView.readPurchaseMenu());
        outputView.printEventPreview(customer.getVisitDate());
        outputView.printOrderMenus(customer.getPurchaseMenus());
        outputView.printTotalPurchaseAmount(customer.calcPurchaseAmount());
        outputView.printPresentEvent(customer.calcAppliedEvent());
        outputView.printAppliedEvent(customer.calcAppliedEvent());
        outputView.printTotalDiscount(customer.calcTotalDiscountedAmount());
        outputView.printEstimatedAmount(customer.calcPurchaseAmount() - customer.calcTotalDiscountedAmount());
        outputView.printEventBadge(customer.calcEventBadge());
    }
}
