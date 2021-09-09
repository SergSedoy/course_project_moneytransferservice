package ru.netology.course_project_moneytransferservice.pojo;

public class ConfirmForm {
    private final String operationId;
    private final String code;

    public ConfirmForm(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ConfirmForm{" +
                "operationId='" + operationId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
