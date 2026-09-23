package com.loanmanagement.service;

import com.loanmanagement.model.Repayment;
import com.loanmanagement.service.impl.RepaymentServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepaymentServiceTest {

    private RepaymentService repaymentService = new RepaymentServiceImpl();

    @Test
    @Order(1)
    void getRepaymentByIdTest() {

        Repayment repayment = repaymentService.getRepaymentById(1);

        assertNotNull(repayment);
    }

    @Test
    @Order(2)
    void updateRepaymentTest() {

        Repayment repayment = new Repayment();

        repayment.setRepaymentId(1);
        repayment.setLoanId(1);
        repayment.setAmount(5000);
        repayment.setPaymentDate("2026-09-23");
        repayment.setPaymentMode("CASH");
        repayment.setReferenceNo("REF001");
        repayment.setRemarks("Updated payment");
        repayment.setRecordedBy(1);
        repayment.setCreatedAt("2026-09-23");

        repaymentService.updateRepayment(repayment);

        assertTrue(true);
    }

    @Test
    @Order(3)
    void deleteRepaymentTest() {

        repaymentService.deleteRepayment(1);

        assertTrue(true);
    }
}