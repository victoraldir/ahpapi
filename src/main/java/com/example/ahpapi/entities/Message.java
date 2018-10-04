package com.example.ahpapi.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "VW_MESSAGE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

    @Id
    private long id;
    private String tailNumber;
    @Column(name = "type")
    private String type;
    private String faultCode;
    private String messageStatus;
    private Date dateTime;
    private String message;

    private String mmIdList;

    @Transient
    private List<MessageCorrelated> maintMessage;

    public List<MessageCorrelated> getMaintMessage() {
        return maintMessage;
    }

    public void setMaintMessage(List<MessageCorrelated> maintMessage) {
        this.maintMessage = maintMessage;
    }

    public long getId() {
        return id;
    }

    public String getMmIdList() {
        return mmIdList;
    }

    public void setMmIdList(String mmIdList) {
        this.mmIdList = mmIdList;
    }

    public void setId(long id) {
        this.id = id;
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
