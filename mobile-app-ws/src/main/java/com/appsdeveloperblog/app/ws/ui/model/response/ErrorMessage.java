package com.appsdeveloperblog.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {

    private Date timestamp;
    private String message;

    public ErrorMessage() {}

    public ErrorMessage(Date timestamp, String message){
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date time) {
        this.timestamp = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
