package com.iesam.digitallibrary.feature.loan.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GetFinalizedLoansUseCaseTest {

    @Mock
    LoanRepository loanRepository;

    GetFinalizedLoansUseCase getFinalizedLoansUseCase;

    @BeforeEach
    public void setUp() {
        getFinalizedLoansUseCase = new GetFinalizedLoansUseCase(loanRepository);
    }

    @AfterEach
    public void clear() {
        getFinalizedLoansUseCase = null;
    }

    @Test
    public void cuandoSeSolicitanLosPrestamosFinalizadosEntoncesSeDevulveUnaListaDeLosCasosDeUsoFinalizados() {
        Loan loanTrue = new Loan("001", null, null, null, null, true);
        Loan loanFalse = new Loan("002", null, null, null, null, false);
        List<Loan> allLoans = new ArrayList<>();
        allLoans.add(loanTrue);
        allLoans.add(loanFalse);

        Mockito.when(loanRepository.getAllLoans()).thenReturn(allLoans);

        List<Loan> finalizedLoans = getFinalizedLoansUseCase.execute();
        Assertions.assertEquals(finalizedLoans.size(), 1);
        Assertions.assertTrue(finalizedLoans.get(0).finalized);
    }
}
