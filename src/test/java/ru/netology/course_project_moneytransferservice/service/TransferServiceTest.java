package ru.netology.course_project_moneytransferservice.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.course_project_moneytransferservice.Card;
import ru.netology.course_project_moneytransferservice.TransferForm;
import ru.netology.course_project_moneytransferservice.repository.TransferRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {

    @Test
    void transferFormValid() {
        TransferRepository transferRepository = Mockito.mock(TransferRepository.class);
        TransferForm transferForm = new TransferForm("5555555555555555", "11/21", "123", "1111111111111111", new TransferForm.Amount("RUR", 1_000_000));
        List<TransferForm> list = new ArrayList<>();
        list.add(transferForm);

        Mockito.when(transferRepository.getId(transferForm)).thenReturn(list.indexOf(transferForm));

        assertEquals(0, transferRepository.getId(transferForm));
    }

    @Test
    void testTransferFormValidInput() {
        TransferRepository transferRepository = Mockito.mock(TransferRepository.class);
        TransferForm transferForm = new TransferForm("5555555555555555", "11/21", "123", "1111111111111111", new TransferForm.Amount("RUR", 1_000_000));

        Mockito.when(transferRepository.validInputData(transferForm)).thenReturn(true);
        assertTrue(transferRepository.validInputData(transferForm));
    }

    @Test
    void transferFormParseToCard() {
        TransferRepository transferRepository = Mockito.mock(TransferRepository.class);
        TransferForm transferForm = new TransferForm("5555555555555555", "11/21", "123", "1111111111111111", new TransferForm.Amount("RUR", 1_000_000));
        Card cardFrom = new Card("5555555555555555", "11/21", "123", 1_000_000.00);

        Mockito.when(transferRepository.searchCard(transferForm.getCardFromNumber())).thenReturn(cardFrom);
        assertEquals(cardFrom, transferRepository.searchCard(transferForm.getCardFromNumber()));
    }

    @Test
    void translation() {
        TransferRepository transferRepository = Mockito.mock(TransferRepository.class);
        Card cardFrom = new Card("5555555555555555", "11/21", "123", 1_000_000.00);

        Mockito.when(transferRepository.getAmount(cardFrom)).thenReturn(cardFrom.getAmount());
        assertEquals(1_000_000.00, transferRepository.getAmount(cardFrom));
    }
}