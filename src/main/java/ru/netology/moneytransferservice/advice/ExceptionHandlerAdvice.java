package ru.netology.moneytransferservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.moneytransferservice.exception.ConfirmError;
import ru.netology.moneytransferservice.exception.ErrorInputData;
import ru.netology.moneytransferservice.exception.ErrorTransfer;
import ru.netology.moneytransferservice.model.ResponseError;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<ResponseError> errorInputDataHandler(ErrorInputData e) {
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConfirmError.class)
    public ResponseEntity<ResponseError> confirmErrorHandler(ConfirmError e) {
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<ResponseError> errorTransferHandler(ErrorTransfer e) {
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
