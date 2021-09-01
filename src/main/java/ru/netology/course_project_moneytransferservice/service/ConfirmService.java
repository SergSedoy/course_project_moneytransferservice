package ru.netology.course_project_moneytransferservice.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.netology.course_project_moneytransferservice.BaseResponse;
import ru.netology.course_project_moneytransferservice.ConfirmForm;
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
