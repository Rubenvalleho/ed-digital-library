package com.iesam.digitallibrary.feature.loan.data;

import com.iesam.digitallibrary.feature.loan.data.local.LoanLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.Loan;
import com.iesam.digitallibrary.feature.loan.domain.LoanRepository;

import java.util.List;

public class LoanDataRepository implements LoanRepository {
    private LoanLocalDataSource loanLocalDataSource;

    public LoanDataRepository(LoanLocalDataSource loanLocalDataSource) {
        this.loanLocalDataSource = loanLocalDataSource;
    }

    @Override
    public void saveLoan(Loan loan) {
        loanLocalDataSource.save(loan);
    }

}
