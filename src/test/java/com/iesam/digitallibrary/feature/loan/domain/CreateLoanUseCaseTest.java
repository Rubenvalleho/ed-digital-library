package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBookRepository;
import com.iesam.digitallibrary.feature.user.domain.User;
import com.iesam.digitallibrary.feature.user.domain.UserRepository;
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

    @Mock
    UserRepository userRepository;

    @Mock
    DigitalBookRepository digitalBookRepository;

    @Mock
    LoanFactory loanFactory;

    CreateLoanUseCase createLoanUseCase;

    @BeforeEach
    public void setUp() {
        createLoanUseCase = new CreateLoanUseCase(loanRepository,  loanFactory,userRepository, digitalBookRepository);
    }

    @AfterEach
    public void clear() {
        createLoanUseCase = null;
    }

    @Test
    public void cuandoReciboLosDatosDeUnPrestamoEntoncesLoGuardo() {
        Mockito.when(userRepository.getUser("001")).thenReturn(new User("001", null, null, null, null, null));
        User user = userRepository.getUser("001");

        Mockito.when(digitalBookRepository.getDigitalBook("1")).thenReturn(new DigitalBook("1", null, null, null, null));
        DigitalBook digitalBook = digitalBookRepository.getDigitalBook("1");


        Loan loan = new Loan( user, digitalBook, false);
        Mockito.when(loanFactory.build(null, null, false)).thenReturn(loan);

        createLoanUseCase.execute(null, null);

        Mockito.verify(loanRepository, Mockito.times(1)).saveLoan(loan);
    }
}
