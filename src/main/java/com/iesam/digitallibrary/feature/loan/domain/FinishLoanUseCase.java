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
        Loan loanFinished = factory.build(loan.id, loan.user, loan.digitalBook, loan.loanInitialDate, loan.returnDate, true);
        loanRepository.finishLoan(loanFinished);
    }
}
