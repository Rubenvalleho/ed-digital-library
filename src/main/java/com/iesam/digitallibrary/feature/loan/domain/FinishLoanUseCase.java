package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;

public class FinishLoanUseCase {
    private LoanRepository loanRepository;

    public FinishLoanUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute (String id) {
        Loan loan =
        loanRepository.finishLoan();
    }
}
