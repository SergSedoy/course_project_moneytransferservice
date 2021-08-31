package ru.netology.course_project_moneytransferservice;

public class BaseResponse {
    private final String operationId;
    private final String code;
    private final Integer id;

    public BaseResponse(String operationId) {
        this.operationId = operationId;
        this.code = "3555";

        this.id = 333;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }

    public Integer getId() {
        return id;
    }
}
