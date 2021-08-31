package ru.netology.course_project_moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.course_project_moneytransferservice.Card;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TransferRepository {
    private static Map<String, Card> mapa = new ConcurrentHashMap<>();
    static {
        mapa.put("1111111111111111", new Card("1111111111111111", "11/21", "123", 0.00));
        mapa.put("2222222222222222", new Card("2222222222222222", "11/21", "123", 0.00));
        mapa.put("5555555555555555", new Card("5555555555555555", "11/21", "123", 1_000_000.00));
    }

    public Card searchCard(String CardFromNumber) { return mapa.get(CardFromNumber);}

    public double getAmount(Card card) {
    return mapa.get(card.getCardNumber()).getAmount();
    }

    public void setAmount(Card cardTo, double amount) {
        mapa.get(cardTo.getCardNumber()).setAmount(amount);
        System.out.println("деньги " + amount + " зачислены на счет карты " + cardTo.getCardNumber());
        System.out.println(cardTo);
    }
}
