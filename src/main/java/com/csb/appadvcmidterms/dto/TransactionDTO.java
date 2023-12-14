package com.csb.appadvcmidterms.dto;

import com.csb.appadvcmidterms.model.Transaction;

public class TransactionDTO {

    private Integer transactionId;

    private String date;

    private String user;

    private String action;

    public TransactionDTO() {}

    public TransactionDTO(Integer transactionId, String date, String user, String action) {
        this.transactionId = transactionId;
        this.date = date;
        this.user = user;
        this.action = action;
    }

    public TransactionDTO (Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.date = transaction.getDate();
        this.user = transaction.getUser();
        this.action = transaction.getAction();
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
