package ru.netology.course_project_moneytransferservice.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.course_project_moneytransferservice.BaseResponse;
import ru.netology.course_project_moneytransferservice.TransferForm;
import ru.netology.course_project_moneytransferservice.service.TransferService;

@RestController
public class TransferController {
    private static final String SUCCESS_STATUS = "Success transfer";
    private static final String ERROR_STATUS = "error";
    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
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
    public void transferMoney(@RequestBody TransferForm transferForm) {
        System.out.println("money transfer!!! " + transferForm.getCardFromValidTill());
        System.out.println("money transfer!!! " + transferForm.getCardToNumber());
        System.out.println("перевод получен!!! " + transferForm.getAmount().getValue() + " " + transferForm.getAmount().getCurrency());
        transferService.transferFormParse(transferForm);
    }

    @PostMapping("/confirmOperation")
    public BaseResponse confirmOperation() {
        System.out.println("confirmOperation - успех");
        return new BaseResponse(SUCCESS_STATUS);
    }

}
