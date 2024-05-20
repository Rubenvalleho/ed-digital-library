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

    FinishLoanUseCase finishLoanUseCase;

    @BeforeEach
    public void setUp() {
        finishLoanUseCase = new FinishLoanUseCase(loanRepository);
    }

    @AfterEach
    public void clear() {
        finishLoanUseCase = null;
    }

    @Test
    public void reciboUnCodigoDePrestamoYEntoncesLoFinalizo() {
        Loan loanNotFinalized = new Loan("001",null,null,null,null,false);
        Mockito.when(loanRepository.getLoan("001")).thenReturn(loanNotFinalized);
        String loanCode = "001";

        finishLoanUseCase.execute(loanCode);

        ArgumentCaptor<Loan> loanCaptor = ArgumentCaptor.forClass(Loan.class);

        Mockito.verify(loanRepository, Mockito.times(1)).finishLoan(loanCaptor.capture());

        Loan loanReceived = loanCaptor.getValue();

        Assertions.assertEquals(loanReceived.id, "001");
        Assertions.assertTrue(loanReceived.finalized);
    }
}
