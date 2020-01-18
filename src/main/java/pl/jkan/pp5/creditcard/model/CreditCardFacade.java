package pl.jkan.pp5.creditcard.model;

import java.util.List;
import java.util.stream.Collectors;

public class CreditCardFacade {
    private CreditCardStorage creditCardStorage;

    public CreditCardFacade(CreditCardStorage creditCardStorage) {
        this.creditCardStorage = creditCardStorage;
    }

    public void withdraw(WithdrawCommand withdrawCommand) {
        CreditCard creditCard = creditCardStorage.load(withdrawCommand.getNumber());
        creditCard.withdraw(withdrawCommand.getAmount());
        creditCardStorage.add(creditCard);
    }

    public CardSummary getSummary(String number) {
        CreditCard creditCard = creditCardStorage.load(number);
        return creditCard.getSummary();
    }

    public List<CardSummary> getCardsReport() {
        return creditCardStorage.all().stream()
                .map(CreditCard::getSummary)
                .collect(Collectors.toList());
    }
}
