package ru.netology.course_project_moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.course_project_moneytransferservice.Card;
import ru.netology.course_project_moneytransferservice.TransferForm;
import ru.netology.course_project_moneytransferservice.service.TransferService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TransferRepository {
    private static Map<String, Card> mapa = new ConcurrentHashMap<>();
    private static List<TransferForm> list = new ArrayList<>();
    static {
        mapa.put("1111111111111111", new Card("1111111111111111", "11/21", "123", 0.00));
        mapa.put("2222222222222222", new Card("2222222222222222", "11/21", "123", 0.00));
        mapa.put("5555555555555555", new Card("5555555555555555", "11/21", "123", 1_000_000.00));
    }

    public static List<TransferForm> getList() {
        return list;
    }

    public int getId(TransferForm transferForm) {
        list.add(transferForm);
        return list.indexOf(transferForm);
    }

    public boolean validInputData(TransferForm transferForm) {
        return mapa.containsKey(transferForm.getCardFromNumber()) && mapa.containsKey(transferForm.getCardToNumber());
    }

    public Card searchCard(String cardFromNumber) { return mapa.get(cardFromNumber);}

    public double getAmount(Card card) {
    return mapa.get(card.getCardNumber()).getAmount();
    }

    public void setAmount(Card card, double amount) {
        mapa.get(card.getCardNumber()).setAmount(amount);
    }



}
