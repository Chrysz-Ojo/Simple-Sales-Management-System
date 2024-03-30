package com.chrysz.simple.sale.management.system.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {

    private String message;
    private HttpStatus status;
    public ResourceNotFoundException(String message) {


        this.message = message;
        this.status = status;
    }
}
