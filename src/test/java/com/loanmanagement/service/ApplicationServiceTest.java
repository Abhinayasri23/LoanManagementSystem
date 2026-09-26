package com.loanmanagement.service;

import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.service.impl.ApplicationServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationServiceTest {

    private ApplicationService applicationService =
            new ApplicationServiceImpl();

    @Test
    void getApplicationByIdTest() {

        LoanApplication application =
                applicationService.getApplicationById(1);

        assertNotNull(application);
        assertEquals(1, application.getApplicationId());
    }

    @Test
    void getApplicationByIdNotFoundTest() {

        assertThrows(
                NotFoundException.class,
                () -> applicationService.getApplicationById(999)
        );
    }

    @Test
    void updateApplicationTest() {

        LoanApplication application =
                applicationService.getApplicationById(1);

        application.setRemarks("Application updated");

        applicationService.updateApplication(application);

        LoanApplication updatedApplication =
                applicationService.getApplicationById(1);

        assertNotNull(updatedApplication);
        assertEquals(
                "Application updated",
                updatedApplication.getRemarks()
        );
    }
}