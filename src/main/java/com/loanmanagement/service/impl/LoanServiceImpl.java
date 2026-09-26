package com.loanmanagement.service.impl;

import com.loanmanagement.dao.LoanDao;
import com.loanmanagement.dao.impl.LoanDaoImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.Loan;
import com.loanmanagement.service.LoanService;
import com.loanmanagement.util.ValidationUtil;

public class LoanServiceImpl implements LoanService {

    private LoanDao loanDao = new LoanDaoImpl();

    @Override
    public void addLoan(Loan loan) {

        ValidationUtil.validatePositive(
                loan.getApplicationId(), "Application ID");

        ValidationUtil.validatePositive(
                loan.getCustomerId(), "Customer ID");

        ValidationUtil.validatePositive(
                loan.getLoanTypeId(), "Loan Type ID");

        ValidationUtil.validatePositive(
                loan.getPrincipalAmount(), "Principal Amount");

        ValidationUtil.validatePositive(
                loan.getInterestRate(), "Interest Rate");

        ValidationUtil.validatePositive(
                loan.getTenureMonths(), "Tenure Months");

        ValidationUtil.validatePositive(
                loan.getCreatedBy(), "Created By");

        loanDao.addLoan(loan);
    }

    @Override
    public Loan getLoanById(int loanId) {

        ValidationUtil.validatePositive(
                loanId, "Loan ID");

        Loan loan = loanDao.getLoanById(loanId);

        if (loan == null) {
            throw new NotFoundException(
                    "Loan not found with ID: " + loanId);
        }

        return loan;
    }

    @Override
    public void updateLoan(Loan loan) {

        ValidationUtil.validatePositive(
                loan.getLoanId(), "Loan ID");

        ValidationUtil.validatePositive(
                loan.getApplicationId(), "Application ID");

        ValidationUtil.validatePositive(
                loan.getCustomerId(), "Customer ID");

        ValidationUtil.validatePositive(
                loan.getLoanTypeId(), "Loan Type ID");

        ValidationUtil.validatePositive(
                loan.getPrincipalAmount(), "Principal Amount");

        ValidationUtil.validatePositive(
                loan.getInterestRate(), "Interest Rate");

        ValidationUtil.validatePositive(
                loan.getTenureMonths(), "Tenure Months");

        ValidationUtil.validatePositive(
                loan.getCreatedBy(), "Created By");

        loanDao.updateLoan(loan);
    }

    @Override
    public void deleteLoan(int loanId) {

        ValidationUtil.validatePositive(
                loanId, "Loan ID");

        loanDao.deleteLoan(loanId);
    }
}