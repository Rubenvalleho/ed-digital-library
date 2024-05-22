package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.user.domain.User;

public class LoanFactory {

    public Loan build(User user, DigitalBook digitalBook, Boolean finalized) {
        return new Loan(user, digitalBook, finalized);
    }

    public Loan buildFinalizedLoan(Loan loan){
        return new Loan(loan.id, loan.user, loan.digitalBook, loan.loanInitialDate, loan.returnDate, true);
    }
}
