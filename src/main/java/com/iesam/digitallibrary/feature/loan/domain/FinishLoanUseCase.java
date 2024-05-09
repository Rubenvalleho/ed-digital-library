package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;

public class FinishLoanUseCase {
    private LoanRepository loanRepository;

    public FinishLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute (String id) {
        Loan loan = loanRepository.getLoan(id);
        Loan loanFinished = new Loan(loan.id, loan.user,loan.digitalBook, loan.loanInitialDate, loan.returnDate, true);
        loanRepository.finishLoan(loanFinished);
    }
}
