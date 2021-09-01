package ru.netology.course_project_moneytransferservice.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.course_project_moneytransferservice.BaseResponse;
import ru.netology.course_project_moneytransferservice.ConfirmForm;
import ru.netology.course_project_moneytransferservice.TransferForm;
import ru.netology.course_project_moneytransferservice.exception.InvalidInputException;
import ru.netology.course_project_moneytransferservice.exception.TransferException;
import ru.netology.course_project_moneytransferservice.service.ConfirmService;
import ru.netology.course_project_moneytransferservice.service.TransferService;

@RestController
public class TransferController {
    private TransferService transferService;
    private ConfirmService confirmService;

    public TransferController(TransferService transferService, ConfirmService confirmService) {
        this.transferService = transferService;
        this.confirmService = confirmService;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
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
