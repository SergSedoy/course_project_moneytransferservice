package ru.netology.course_project_moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.netology.course_project_moneytransferservice.pojo.BaseResponse;
import ru.netology.course_project_moneytransferservice.pojo.ConfirmForm;
import ru.netology.course_project_moneytransferservice.repository.TransferRepository;

@Service
public class ConfirmService {
    private TransferRepository transferRepository;

    public ConfirmService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public BaseResponse confirmFormValid(ConfirmForm confirmForm) {
        confirmForm.getOperationId();
        return new BaseResponse("Success confirm");
    }

}
