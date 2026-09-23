package com.loanmanagement.service.impl;

import com.loanmanagement.dao.RepaymentDao;
import com.loanmanagement.dao.impl.RepaymentDaoImpl;
import com.loanmanagement.model.Repayment;
import com.loanmanagement.service.RepaymentService;

public class RepaymentServiceImpl implements RepaymentService {

    private RepaymentDao repaymentDao = new RepaymentDaoImpl();

    @Override
    public void addRepayment(Repayment repayment) {
        repaymentDao.addRepayment(repayment);
    }

    @Override
    public Repayment getRepaymentById(int repaymentId) {
        return repaymentDao.getRepaymentById(repaymentId);
    }

    @Override
    public void updateRepayment(Repayment repayment) {
        repaymentDao.updateRepayment(repayment);
    }

    @Override
    public void deleteRepayment(int repaymentId) {
        repaymentDao.deleteRepayment(repaymentId);
    }
}