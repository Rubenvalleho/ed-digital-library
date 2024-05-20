package com.iesam.digitallibrary.feature.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GetNotFinalizedLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;

    GetNotFinalizedLoansUseCase getNotFinalizedLoansUseCase;

    @BeforeEach
    public void setUp() {
        getNotFinalizedLoansUseCase = new GetNotFinalizedLoansUseCase(loanRepository);
    }

    @AfterEach
    public void clear() {
        getNotFinalizedLoansUseCase = null;
    }

    @Test
    public void cuandoSeSolicitanLosPrestamosNoFinalizadoEntoncesDevuelvoLosPrestamosNoFinalizados() {
        Loan loanFalse = new Loan("001", null, null, null, null, false);
        Loan loanTrue = new Loan("002", null , null, null, null, true);
        List<Loan> allLoans = new ArrayList<>();
        allLoans.add(loanFalse);
        allLoans.add(loanTrue);

        Mockito.when(loanRepository.getAllLoans()).thenReturn(allLoans);

        List<Loan> notFinalizedLoans = getNotFinalizedLoansUseCase.execute();
    }
}
