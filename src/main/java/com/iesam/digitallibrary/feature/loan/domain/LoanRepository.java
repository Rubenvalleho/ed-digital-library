package com.iesam.digitallibrary.feature.loan.domain;

public interface LoanRepository {
    void saveLoan(Loan loan);
    void deleteLoan(String id);
    void finishLoan(Loan loan);
}
