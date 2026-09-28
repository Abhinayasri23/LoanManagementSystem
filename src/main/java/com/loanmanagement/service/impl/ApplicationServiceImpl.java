package com.loanmanagement.service.impl;

import com.loanmanagement.dao.LoanApplicationDao;
import com.loanmanagement.dao.impl.LoanApplicationDaoImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.service.ApplicationService;
import com.loanmanagement.util.ValidationUtil;

public class ApplicationServiceImpl implements ApplicationService {

    private LoanApplicationDao applicationDao =
            new LoanApplicationDaoImpl();


    // ================= ADD =================

    @Override
    public void addApplication(
            LoanApplication application) {

        ValidationUtil.validatePositive(
                application.getCustomerId(),
                "Customer ID");

        ValidationUtil.validatePositive(
                application.getLoanTypeId(),
                "Loan Type ID");

        ValidationUtil.validatePositive(
                application.getRequestedAmount(),
                "Requested Amount");

        ValidationUtil.validatePositive(
                application.getTenureMonths(),
                "Tenure Months");

        ValidationUtil.validateNotEmpty(
                application.getPurpose(),
                "Purpose");

        applicationDao.addLoanApplication(
                application);
    }


    // ================= GET =================

    @Override
    public LoanApplication getApplicationById(
            int applicationId) {

        ValidationUtil.validatePositive(
                applicationId,
                "Application ID");

        LoanApplication application =
                applicationDao.getLoanApplicationById(
                        applicationId);

        if (application == null) {

            throw new NotFoundException(
                    "Loan application not found with ID: "
                            + applicationId);
        }

        return application;
    }


    // ================= UPDATE =================

    @Override
    public void updateApplication(
            LoanApplication application) {

        ValidationUtil.validatePositive(
                application.getApplicationId(),
                "Application ID");

        ValidationUtil.validatePositive(
                application.getCustomerId(),
                "Customer ID");

        ValidationUtil.validatePositive(
                application.getLoanTypeId(),
                "Loan Type ID");

        ValidationUtil.validatePositive(
                application.getRequestedAmount(),
                "Requested Amount");

        ValidationUtil.validatePositive(
                application.getTenureMonths(),
                "Tenure Months");

        ValidationUtil.validateNotEmpty(
                application.getPurpose(),
                "Purpose");

        applicationDao.updateLoanApplication(
                application);
    }


    // ================= DELETE =================

    @Override
    public void deleteApplication(
            int applicationId) {

        ValidationUtil.validatePositive(
                applicationId,
                "Application ID");

        applicationDao.deleteLoanApplication(
                applicationId);
    }


    // ================= APPROVE =================

    @Override
    public void approveApplication(
            int applicationId) {

        ValidationUtil.validatePositive(
                applicationId,
                "Application ID");

        LoanApplication application =
                getApplicationById(applicationId);

        if (!"PENDING".equalsIgnoreCase(
                application.getStatus())) {

            throw new IllegalStateException(
                    "Only PENDING applications can be approved.");
        }

        application.setStatus("APPROVED");

        applicationDao.updateLoanApplication(
                application);
    }


    // ================= REJECT =================

    @Override
    public void rejectApplication(
            int applicationId) {

        ValidationUtil.validatePositive(
                applicationId,
                "Application ID");

        LoanApplication application =
                getApplicationById(applicationId);

        if (!"PENDING".equalsIgnoreCase(
                application.getStatus())) {

            throw new IllegalStateException(
                    "Only PENDING applications can be rejected.");
        }

        application.setStatus("REJECTED");

        applicationDao.updateLoanApplication(
                application);
    }
}