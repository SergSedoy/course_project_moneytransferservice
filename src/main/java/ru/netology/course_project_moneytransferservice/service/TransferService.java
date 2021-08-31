package ru.netology.course_project_moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.netology.course_project_moneytransferservice.Card;
import ru.netology.course_project_moneytransferservice.TransferForm;
import ru.netology.course_project_moneytransferservice.repository.TransferRepository;

@Service
public class TransferService {
    private TransferRepository transferRepository;
//    private static final Logger logger = LogManager.getLogger(TransferService.class);

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public void transferFormParse(TransferForm transferForm) {
        Card cardFrom = transferRepository.searchCard(transferForm.getCardFromNumber());
        Card cardTo = transferRepository.searchCard(transferForm.getCardToNumber());
        translation(cardFrom, cardTo, transferForm.getAmount().getValue());
    }

    public void translation(Card cardFrom, Card cardTo, double amount) {
        double amountOnAccountCardFrom = transferRepository.getAmount(cardFrom);
        double amountOnAccountCardTo = transferRepository.getAmount(cardTo);
        double amountWithoutComission = amount - (amount * 0.01);

        if (amount <= amountOnAccountCardFrom) {
            transferRepository.setAmount(cardTo, amountOnAccountCardTo + amountWithoutComission);
            transferRepository.setAmount(cardFrom, amountOnAccountCardFrom - amount);
//            logger.info("списание с карты " + cardFrom.getCardNumber() + " на карту " + cardTo.getCardNumber() + ", сумма - "
//            + amountWithoutComission + ", комиссия - " + amount * 0.01 + ". Деньги успешно переведены!");
        } else {
            System.out.println("на счете не достаточно средств!");
        }

    }
}
