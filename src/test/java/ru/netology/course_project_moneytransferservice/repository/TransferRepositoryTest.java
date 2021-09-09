package ru.netology.course_project_moneytransferservice.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.course_project_moneytransferservice.pojo.Card;

import static org.junit.jupiter.api.Assertions.*;

class TransferRepositoryTest {

    @Test
    void searchCardTest() {
        TransferRepository transferRepository = Mockito.mock(TransferRepository.class);
        Card cardFrom = new Card("5555555555555555", "11/21", "123", 1_000_000.00);

        Mockito.when(transferRepository.searchCard("5555555555555555")).thenReturn(cardFrom);

        assertEquals(cardFrom, transferRepository.searchCard("5555555555555555"));
    }

    @Test
    void getAmountTest() {
        TransferRepository transferRepository = Mockito.mock(TransferRepository.class);
        Card card = new Card("5555555555555555", "11/21", "123", 1_000_000.00);

        Mockito.when(transferRepository.getAmount(card)).thenReturn(1000000.00);

        assertEquals(1_000_000.00, transferRepository.getAmount(card));
    }
}