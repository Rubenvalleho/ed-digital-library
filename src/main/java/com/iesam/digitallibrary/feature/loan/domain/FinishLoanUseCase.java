package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;

public class FinishLoanUseCase {
    private LoanRepository loanRepository;

    private LoanFactory factory;

    public FinishLoanUseCase(LoanRepository loanRepository, LoanFactory loanFactory) {
        this.loanRepository = loanRepository;
        this.factory = loanFactory;
    }

    public void execute (String id) {
        Loan loan = loanRepository.getLoan(id);
        Loan loanFinalized = factory.buildFinalizedLoan(loan);
        loanRepository.finishLoan(loanFinalized);
    }
}
