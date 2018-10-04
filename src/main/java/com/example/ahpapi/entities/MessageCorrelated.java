package com.example.ahpapi.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "VW_CORRELATED_MESSAGE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageCorrelated {

    @Id
    @Column(name = "message_id")
    private long id;

    @Column(name = "message_id_text")
    private String messageIdText;

    private String tailNumber;
    private String type;
    private String faultCode;
    private String messageStatus;
    private Date dateTime;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageIdText() {
        return messageIdText;
    }

    public void setMessageIdText(String messageIdText) {
        this.messageIdText = messageIdText;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
