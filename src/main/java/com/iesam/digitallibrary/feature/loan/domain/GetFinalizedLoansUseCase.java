package com.iesam.digitallibrary.feature.loan.domain;

import java.util.ArrayList;
import java.util.List;

public class GetFinalizedLoansUseCase {
    private LoanRepository loanRepository;

    public GetFinalizedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        List<Loan> allLoans = loanRepository.getAllLoans();
        List<Loan> finalizedLoans = new ArrayList<>();
        for (Loan loan : allLoans) {
            if (loan.finalized) {
                finalizedLoans.add(loan);
            }
        }
        return finalizedLoans;
    }
}
