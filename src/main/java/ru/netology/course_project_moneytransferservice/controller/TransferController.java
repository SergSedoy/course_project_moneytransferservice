package ru.netology.course_project_moneytransferservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.course_project_moneytransferservice.pojo.BaseResponse;
import ru.netology.course_project_moneytransferservice.pojo.ConfirmForm;
import ru.netology.course_project_moneytransferservice.pojo.TransferForm;
import ru.netology.course_project_moneytransferservice.exception.InvalidInputException;
import ru.netology.course_project_moneytransferservice.exception.TransferException;
import ru.netology.course_project_moneytransferservice.service.ConfirmService;
import ru.netology.course_project_moneytransferservice.service.TransferService;

@RestController
public class TransferController {
    private final TransferService transferService;
    private final ConfirmService confirmService;

    public TransferController(TransferService transferService, ConfirmService confirmService) {
        this.transferService = transferService;
        this.confirmService = confirmService;
    }



    @PostMapping("/transfer")
    public BaseResponse transferMoney(@RequestBody TransferForm transferForm) {
        return transferService.transferFormValid(transferForm);
    }

    @PostMapping("/confirmOperation")
    public BaseResponse confirmOperation(@RequestBody ConfirmForm confirmForm) {
        return confirmService.confirmFormValid(confirmForm);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> exceptionIIE (InvalidInputException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransferException.class)
    public ResponseEntity<String> exceptionTE (TransferException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
