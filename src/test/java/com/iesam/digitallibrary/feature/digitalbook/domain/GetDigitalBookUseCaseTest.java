package com.iesam.digitallibrary.feature.digitalbook.domain;

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
public class GetDigitalBookUseCaseTest {


    @Mock
    DigitalBookRepository digitalBookRepository;

    GetDigitalBookUseCase getDigitalBookUseCase;

    @BeforeEach
    public void setUp() {
        getDigitalBookUseCase = new GetDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    public void clear() {
        getDigitalBookUseCase = null;
    }

    @Test
    public void reciboUnCodigoYEntoncesDevuelvoUnLibroDigital() {
        DigitalBook digitalBookExpected = new DigitalBook("1", "Amanecer rojo", "Pierce Brown",
                "RNA", "Ayer");
        Mockito.when(digitalBookRepository.getDigitalBook("1")).thenReturn(digitalBookExpected);

        DigitalBook digitalBookReceived = getDigitalBookUseCase.execute("1");

        Assertions.assertEquals(digitalBookReceived.id, digitalBookExpected.id);
        Assertions.assertEquals(digitalBookReceived.title, digitalBookExpected.title);
        Assertions.assertEquals(digitalBookReceived.author, digitalBookExpected.author);
        Assertions.assertEquals(digitalBookReceived.editorial, digitalBookExpected.editorial);
        Assertions.assertEquals(digitalBookReceived.releaseDate, digitalBookExpected.releaseDate);
    }

    @Test
    public void cuandoReciboUnCodigoNoValidoEntoncesDevuelvoUnNull() {
        String notValidId = "2";

        Mockito.when(digitalBookRepository.getDigitalBook("2")).thenReturn(null);

        DigitalBook digitalBookReceived = getDigitalBookUseCase.execute("2");

        Assertions.assertNull(digitalBookReceived);
    }
}
