package ru.netology.course_project_moneytransferservice.pojo;

public class BaseResponse {
    private final String operationId;
    private final Integer id;

    public BaseResponse(String operationId) {
        this.operationId = operationId;
        this.id = 333;
    }

    public BaseResponse(String operationId, Integer id) {
        this.operationId = operationId;
        this.id = id;
    }

    public String getOperationId() {
        return operationId;
    }

    public Integer getId() {
        return id;
    }
}
