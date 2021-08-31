package ru.netology.course_project_moneytransferservice;

public class ConfirmForm {
    private final String operationId;
    private final String code;

    public ConfirmForm(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }
}
