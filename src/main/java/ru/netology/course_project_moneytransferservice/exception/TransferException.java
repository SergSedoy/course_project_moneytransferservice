package ru.netology.course_project_moneytransferservice.exception;

public class TransferException extends RuntimeException {
    public TransferException(String message) {
        super(message);
    }
}
