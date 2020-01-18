package pl.jkan.pp5.creditcard.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryCreditCardStorage implements CreditCardStorage {
    Map<String, CreditCard> cards = new ConcurrentHashMap<String, CreditCard>();

    public void add(CreditCard creditCard) {
        cards.put(creditCard.getNumber(), creditCard);
    }

    public CreditCard load(String number) {
        return cards.get(number);
    }
}
