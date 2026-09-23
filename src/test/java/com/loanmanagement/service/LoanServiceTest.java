package com.loanmanagement.service;

import com.loanmanagement.model.Loan;
import com.loanmanagement.service.impl.LoanServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {

    private LoanService loanService = new LoanServiceImpl();

    @Test
    void getLoanByIdTest() {

        Loan loan = loanService.getLoanById(1);

        assertNotNull(loan);
        assertEquals(1, loan.getLoanId());
    }

    @Test
    void updateLoanTest() {

        Loan loan = loanService.getLoanById(1);

        loan.setStatus("ACTIVE");

        loanService.updateLoan(loan);

        Loan updatedLoan = loanService.getLoanById(1);

        assertNotNull(updatedLoan);
        assertEquals("ACTIVE", updatedLoan.getStatus());
    }

    @Test
    void getLoanByIdNotFoundTest() {

        Loan loan = loanService.getLoanById(999);

        assertNull(loan);
    }
}