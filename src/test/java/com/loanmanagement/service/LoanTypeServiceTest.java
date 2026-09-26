package com.loanmanagement.service;

import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.LoanType;
import com.loanmanagement.service.impl.LoanTypeServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTypeServiceTest {

    private LoanTypeService loanTypeService =
            new LoanTypeServiceImpl();

    @Test
    void getLoanTypeByIdTest() {

        LoanType loanType =
                loanTypeService.getLoanTypeById(1);

        assertNotNull(loanType);
        assertEquals(1, loanType.getLoanTypeId());
    }

    @Test
    void getLoanTypeByIdNotFoundTest() {

        assertThrows(
                NotFoundException.class,
                () -> loanTypeService.getLoanTypeById(999)
        );
    }

    @Test
    void updateLoanTypeTest() {

        LoanType loanType =
                loanTypeService.getLoanTypeById(1);

        loanType.setDescription("Updated loan type");

        loanTypeService.updateLoanType(loanType);

        LoanType updatedLoanType =
                loanTypeService.getLoanTypeById(1);

        assertNotNull(updatedLoanType);
        assertEquals(
                "Updated loan type",
                updatedLoanType.getDescription()
        );
    }
}