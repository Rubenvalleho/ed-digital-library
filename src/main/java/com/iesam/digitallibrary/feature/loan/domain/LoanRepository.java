package com.iesam.digitallibrary.feature.loan.domain;

import java.util.List;

public interface LoanRepository {
    void saveLoan(Loan loan);
    void deleteLoan(String id);
    void finishLoan(Loan loan);
    Loan getLoan(String id);
    List<Loan> getAllLoans();
}
