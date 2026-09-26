package com.loanmanagement.service.impl;

import com.loanmanagement.dao.LoanTypeDao;
import com.loanmanagement.dao.impl.LoanTypeDaoImpl;
import com.loanmanagement.exception.NotFoundException;
import com.loanmanagement.model.LoanType;
import com.loanmanagement.service.LoanTypeService;
import com.loanmanagement.util.ValidationUtil;

public class LoanTypeServiceImpl implements LoanTypeService {

    private LoanTypeDao loanTypeDao = new LoanTypeDaoImpl();

    @Override
    public void addLoanType(LoanType loanType) {

        ValidationUtil.validateNotEmpty(
                loanType.getName(), "Loan Type Name");

        ValidationUtil.validatePositive(
                loanType.getInterestRate(), "Interest Rate");

        ValidationUtil.validatePositive(
                loanType.getMinAmount(), "Minimum Amount");

        ValidationUtil.validatePositive(
                loanType.getMaxAmount(), "Maximum Amount");

        ValidationUtil.validatePositive(
                loanType.getMaxTenureMonths(), "Maximum Tenure Months");

        loanTypeDao.addLoanType(loanType);
    }

    @Override
    public LoanType getLoanTypeById(int loanTypeId) {

        ValidationUtil.validatePositive(
                loanTypeId, "Loan Type ID");

        LoanType loanType =
                loanTypeDao.getLoanTypeById(loanTypeId);

        if (loanType == null) {
            throw new NotFoundException(
                    "Loan type not found with ID: " + loanTypeId);
        }

        return loanType;
    }

    @Override
    public void updateLoanType(LoanType loanType) {

        ValidationUtil.validatePositive(
                loanType.getLoanTypeId(), "Loan Type ID");

        ValidationUtil.validateNotEmpty(
                loanType.getName(), "Loan Type Name");

        ValidationUtil.validatePositive(
                loanType.getInterestRate(), "Interest Rate");

        ValidationUtil.validatePositive(
                loanType.getMinAmount(), "Minimum Amount");

        ValidationUtil.validatePositive(
                loanType.getMaxAmount(), "Maximum Amount");

        ValidationUtil.validatePositive(
                loanType.getMaxTenureMonths(), "Maximum Tenure Months");

        loanTypeDao.updateLoanType(loanType);
    }

    @Override
    public void deleteLoanType(int loanTypeId) {

        ValidationUtil.validatePositive(
                loanTypeId, "Loan Type ID");

        loanTypeDao.deleteLoanType(loanTypeId);
    }
}