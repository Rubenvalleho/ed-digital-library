package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.user.domain.User;

public class LoanFactory {

    public Loan build(String id, User user, DigitalBook digitalBook, String initialLoanDate, String returnLoanDate, boolean finalized){
        return new Loan(id, user, digitalBook, initialLoanDate, returnLoanDate,  finalized);
    }

}
