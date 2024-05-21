package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetLoanUseCaseTest {

    @Mock
    LoanRepository loanRepository;

    GetLoanUseCase getLoanUseCase;

    @BeforeEach
    public void setUp() {
        getLoanUseCase = new GetLoanUseCase(loanRepository);
    }

    @AfterEach
    public void clear() {
        getLoanUseCase = null;
    }

    @Test
    public void cuandoReciboUnCodigoValidoEntoncesDevuelvoUnPrestamo() {
        User user = new User(null, null, null, null, null, null);
        DigitalBook digitalBook = new DigitalBook(null, null, null, null, null);
        Loan loanExpected = new Loan("001", user, digitalBook, "19/05/2024", "20/05/2024", false);

        Mockito.when(loanRepository.getLoan("001")).thenReturn(loanExpected);
        Loan loanReceived = getLoanUseCase.execute("001");

        Assertions.assertEquals(loanReceived.id, "001");
        Assertions.assertEquals(loanReceived.user, user);
        Assertions.assertEquals(loanReceived.digitalBook, digitalBook);
        Assertions.assertEquals(loanReceived.loanInitialDate, "19/05/2024");
        Assertions.assertEquals(loanReceived.returnDate, "20/05/2024");
        Assertions.assertEquals(loanReceived.finalized, false);
    }

    @Test
    public void cuandoReciboUnCodigoDeUnPrestamoInexistenteEntoncesDevuelvoNull() {
        String loanCode = "002";

        Mockito.when(loanRepository.getLoan(loanCode)).thenReturn(null);
        Loan loanReceived = getLoanUseCase.execute(loanCode);

        Assertions.assertNull(loanReceived);
    }
}
