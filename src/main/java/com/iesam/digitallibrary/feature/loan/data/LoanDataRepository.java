package com.iesam.digitallibrary.feature.loan.data;

import com.iesam.digitallibrary.feature.loan.data.local.LoanLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.Loan;
import com.iesam.digitallibrary.feature.loan.domain.LoanRepository;

import java.util.List;

public class LoanDataRepository implements LoanRepository {
    private LoanLocalDataSource fileLocalDataSource;
    private LoanLocalDataSource memLocalDataSource;

    public LoanDataRepository(LoanLocalDataSource fileLocalDataSource, LoanLocalDataSource memLocalDataSource) {
        this.fileLocalDataSource = fileLocalDataSource;
        this.memLocalDataSource = memLocalDataSource;
    }

    @Override
    public void saveLoan(Loan loan) {
        fileLocalDataSource.save(loan);
    }

    @Override
    public void deleteLoan(String id) {
        fileLocalDataSource.delete(id);
    }

    @Override
    public void finishLoan(Loan loan) {
        fileLocalDataSource.modify(loan);
    }

    @Override
    public Loan getLoan(String id) {
        Loan loanFile = fileLocalDataSource.findById(id);
        Loan loanMem = memLocalDataSource.findById(id);

        if (loanMem == null) {
            loanMem = loanFile;
            if (loanMem != null) {
                memLocalDataSource.save(loanMem);
            }
            return loanFile;
        }

        if (loanFile != null && !loanFile.equals(loanMem)) {
            memLocalDataSource.save(loanFile);
            return loanFile;
        }
        return loanMem;
    }

    @Override
    public List<Loan> getAllLoans() {
        return fileLocalDataSource.findAll();
    }

}
