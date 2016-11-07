package com.quanlt.vietcomicclean.data.exception;


public class ComicNotFoundException extends Exception {
    public ComicNotFoundException() {
        super();
    }

    public ComicNotFoundException(String message) {
        super(message);
    }

    public ComicNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComicNotFoundException(Throwable cause) {
        super(cause);
    }
}
