package com.test.oneio.model;

/*
 * ErrorResponse is a wrapper class for custome execptions thrown by the application. 
 */
public class ErrorResponse {
    String message;
    int status;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
