package com.adavri.csv.csv.dto;

public class MessageResponse {

    private boolean error;
    private String message;

    public MessageResponse() {
    }

    public MessageResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
