package com.iesam.digitallibrary.feature.digitalbook.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateDigitalBookUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;

    @Mock
    DigitalBookFactory digitalBookFactory;

    CreateDigitalBookUseCase createDigitalBookUseCase;

    @BeforeEach
    public void setUp() {
        createDigitalBookUseCase = new CreateDigitalBookUseCase(digitalBookRepository, digitalBookFactory);
    }

    @AfterEach
    public void clear() {
        createDigitalBookUseCase = null;
    }

    @Test
    public void obtengoUnLibroDigitalYLoGuardo() {
        DigitalBook digitalBook = new DigitalBook("1", null, null, null, null);
        Mockito.when(digitalBookFactory.build("1", null, null, null, null))
                .thenReturn(digitalBook);

        createDigitalBookUseCase.execute("1", null, null, null, null);

        Mockito.verify(digitalBookRepository, Mockito.times(1)).saveDigitalBook(digitalBook);
    }
}
