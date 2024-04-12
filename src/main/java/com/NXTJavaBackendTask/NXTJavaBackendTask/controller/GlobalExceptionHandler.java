package com.NXTJavaBackendTask.NXTJavaBackendTask.controller;

import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CartServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.CouponServiceException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.NXTTaskException;
import com.NXTJavaBackendTask.NXTJavaBackendTask.exception.ProductServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.BindException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NXTTaskException.class)
    public ResponseEntity<String> handleBaseException(NXTTaskException ex){
        return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(CouponServiceException.class)
    public ResponseEntity<String> handleCouponServiceException(CouponServiceException ex){
        return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    }

    @ExceptionHandler(CartServiceException.class)
    public ResponseEntity<String> handleCartServiceException(CartServiceException ex){
        return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity<String> handleValidationException(Exception ex) {
        String errorMessage = ex.getMessage();

        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(ProductServiceException.class)
    public ResponseEntity<String> handleProductServiceException(ProductServiceException ex) {
        String errorMessage = ex.getMessage();

        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleInternalServerError(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getLocalizedMessage());
    }
}
