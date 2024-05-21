package com.iesam.digitallibrary.feature.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeleteLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;

    DeleteLoanUseCase deleteLoanUseCase;

    @BeforeEach
    public void setUp() {
        deleteLoanUseCase = new DeleteLoanUseCase(loanRepository);
    }

    @AfterEach
    public void clear() {
        deleteLoanUseCase = null;
    }

    @Test
    public void cuandoReciboUnCodigoEntoncesEliminoElPrestamo() {
        String loandCode = "002";

        deleteLoanUseCase.execute(loandCode);

        Mockito.verify(loanRepository, Mockito.times(1)).deleteLoan(loandCode);
    }
}
