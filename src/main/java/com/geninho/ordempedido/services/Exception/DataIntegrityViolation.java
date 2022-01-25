package com.geninho.ordempedido.services.Exception;

public class DataIntegrityViolation extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public DataIntegrityViolation(String msg){
        super(msg);
    }

    public DataIntegrityViolation(String msg, Throwable cause){
        super(msg, cause);
    }
}
