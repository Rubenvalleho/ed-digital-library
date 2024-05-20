package com.iesam.digitallibrary.feature.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FinishLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;

    @Mock
    LoanFactory loanFactory;

    FinishLoanUseCase finishLoanUseCase;


    @BeforeEach
    public void setUp() {
        finishLoanUseCase = new FinishLoanUseCase(loanRepository, loanFactory);
    }

    @AfterEach
    public void clear() {
        finishLoanUseCase = null;
    }

    @Test
    public void reciboUnCodigoDePrestamoYEntoncesLoFinalizo() {
        Loan loanNotFinalized = new Loan("001", null, null, null, null, false);
        Mockito.when(loanRepository.getLoan("001")).thenReturn(loanNotFinalized);
        Loan loanFinalized = new Loan("001", null, null, null, null, true);
        Mockito.when(loanFactory.build("001", null, null, null, null, true)).thenReturn(loanFinalized);

        finishLoanUseCase.execute("001");

        Mockito.verify(loanRepository, Mockito.times(1)).finishLoan(loanFinalized);

    }
}
