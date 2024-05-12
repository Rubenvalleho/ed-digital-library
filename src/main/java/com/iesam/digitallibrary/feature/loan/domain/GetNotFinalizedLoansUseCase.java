package com.iesam.digitallibrary.feature.loan.domain;

import java.util.ArrayList;
import java.util.List;

public class GetNotFinalizedLoansUseCase {
    private LoanRepository loanRepository;

    public GetNotFinalizedLoansUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> execute() {
        List<Loan> allLoans = loanRepository.getAllLoans();
        List<Loan> notFinalizedLoans = new ArrayList<>();
        for(Loan loan : allLoans) {
            if (!loan.finalized) {
                notFinalizedLoans.add(loan);
            }
        }
        return notFinalizedLoans;
    }
}
