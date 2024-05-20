package com.iesam.digitallibrary.feature.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;

    CreateLoanUseCase createLoanUseCase;

    @BeforeEach
    public void setUp() {
        createLoanUseCase = new CreateLoanUseCase(loanRepository);
    }

    @AfterEach
    public void clear() {
        createLoanUseCase = null;
    }

    @Test
    public void cuandoReciboLosDatosDeUnPrestamoEntoncesLoGuardo() {
        Loan loan = new Loan("001", null, null, null, null, null);

        createLoanUseCase.execute(loan);

        Mockito.verify(loanRepository, Mockito.times(1)).saveLoan(loan);
    }
}
