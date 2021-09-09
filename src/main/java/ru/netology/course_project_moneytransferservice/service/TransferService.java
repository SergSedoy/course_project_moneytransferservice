package ru.netology.course_project_moneytransferservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.netology.course_project_moneytransferservice.pojo.BaseResponse;
import ru.netology.course_project_moneytransferservice.pojo.Card;
import ru.netology.course_project_moneytransferservice.pojo.TransferForm;
import ru.netology.course_project_moneytransferservice.exception.InvalidInputException;
import ru.netology.course_project_moneytransferservice.exception.TransferException;
import ru.netology.course_project_moneytransferservice.repository.TransferRepository;

@Service
public class TransferService {
    private TransferRepository transferRepository;
    private static final Logger logger = LogManager.getLogger(TransferService.class);

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public BaseResponse transferFormValid(TransferForm transferForm) {
        int id = transferRepository.getId(transferForm);
        if (!transferRepository.validInputData(transferForm))
            throw new InvalidInputException("Error input data cards!");
        return transferFormParseToCard(transferForm);
    }

    public BaseResponse transferFormParseToCard(TransferForm transferForm) {
        Card cardFrom = transferRepository.searchCard(transferForm.getCardFromNumber());
        Card cardTo = transferRepository.searchCard(transferForm.getCardToNumber());
        return translation(cardFrom, cardTo, transferForm.getAmount().getValue());
    }

    public BaseResponse translation(Card cardFrom, Card cardTo, double amount) {
        double amountOnAccountCardFrom = transferRepository.getAmount(cardFrom);
        double amountOnAccountCardTo = transferRepository.getAmount(cardTo);
        double amountWithoutComission = amount - (amount * 0.01);

        if (!(amount <= amountOnAccountCardFrom)) {
            throw new TransferException("There are not enough funds on the account!");
        }
        transferRepository.setAmount(cardTo, amountOnAccountCardTo + amountWithoutComission);
        transferRepository.setAmount(cardFrom, amountOnAccountCardFrom - amount);
        logger.info("Списание с карты " + cardFrom.getCardNumber() + " на карту " + cardTo.getCardNumber() + ", сумма перевода - "
                + amountWithoutComission + ", комиссия - " + amount * 0.01 + ". Деньги успешно переведены!");
        logger.info("------------------------------------------------------------------");
        logger.info("На счету карты " + cardTo.getCardNumber() + ", сумма " + cardTo.getAmount());
        logger.info("На счету карты " + cardFrom.getCardNumber() + ", сумма " + cardFrom.getAmount());
        logger.info("------------------------------------------------------------------");

        return new BaseResponse("Success transfer");
    }
}
