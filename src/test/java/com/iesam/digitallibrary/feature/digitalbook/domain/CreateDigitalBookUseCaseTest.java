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

    CreateDigitalBookUseCase createDigitalBookUseCase;

    @BeforeEach
    public void setUp() {
        createDigitalBookUseCase = new CreateDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    public void clear() {
        createDigitalBookUseCase = null;
    }

    @Test
    public void obtengoUnLibroDigitalYLoGuardo() {
        DigitalBook digitalBook = new DigitalBook("1", null, null, null, null);

        createDigitalBookUseCase.execute(digitalBook);

        Mockito.verify(digitalBookRepository, Mockito.times(1)).saveDigitalBook(digitalBook);
    }
}
