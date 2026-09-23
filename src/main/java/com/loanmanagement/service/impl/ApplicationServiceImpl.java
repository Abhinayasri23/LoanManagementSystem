package com.loanmanagement.service.impl;

import com.loanmanagement.dao.LoanApplicationDao;
import com.loanmanagement.dao.impl.LoanApplicationDaoImpl;
import com.loanmanagement.model.LoanApplication;
import com.loanmanagement.service.ApplicationService;

public class ApplicationServiceImpl implements ApplicationService {

    private LoanApplicationDao applicationDao = new LoanApplicationDaoImpl();

    @Override
    public void addApplication(LoanApplication application) {
        applicationDao.addLoanApplication(application);
    }

    @Override
    public LoanApplication getApplicationById(int applicationId) {
        return applicationDao.getLoanApplicationById(applicationId);
    }

    @Override
    public void updateApplication(LoanApplication application) {
        applicationDao.updateLoanApplication(application);
    }

    @Override
    public void deleteApplication(int applicationId) {
        applicationDao.deleteLoanApplication(applicationId);
    }
}
