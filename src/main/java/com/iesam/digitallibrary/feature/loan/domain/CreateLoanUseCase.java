package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBookFactory;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBookRepository;
import com.iesam.digitallibrary.feature.user.domain.User;
import com.iesam.digitallibrary.feature.user.domain.UserRepository;

public class CreateLoanUseCase {
    private LoanRepository loanRepository;
    private LoanFactory loanFactory;
    private UserRepository userRepository;
    private DigitalBookRepository digitalBookRepository;

    public CreateLoanUseCase(LoanRepository loanRepository, LoanFactory loanFactory, UserRepository userRepository,
                             DigitalBookRepository digitalBookRepository) {
        this.loanRepository = loanRepository;
        this.loanFactory = loanFactory;
        this.userRepository = userRepository;
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute(String userCode, String digitalBookId) {
        User user = userRepository.getUser(userCode);
        DigitalBook digitalBook = digitalBookRepository.getDigitalBook(digitalBookId);
        Loan loan = loanFactory.build(user, digitalBook, false);
        loanRepository.saveLoan(loan);
    }
}
