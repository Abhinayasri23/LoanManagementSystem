package com.loanmanagement.model;

public class Repayment {
    private int repaymentId;
    private int loanId;
    private int installmentNumber;
    private String dueDate;
    private double emiAmount;
    private double principalComponent;
    private double interestComponent;
    private double paidAmount;
    private String paidDate;
    private String paymentMethod;
    private String status;
}
