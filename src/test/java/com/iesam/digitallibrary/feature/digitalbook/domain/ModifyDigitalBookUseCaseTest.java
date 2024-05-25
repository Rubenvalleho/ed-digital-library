package com.iesam.digitallibrary.feature.digitalbook.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ModifyDigitalBookUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;

    @Mock
    DigitalBookFactory digitalBookFactory;

    ModifyDigitalBookUseCase modifyDigitalBookUseCase;

    @BeforeEach
    public void setUp() {
        modifyDigitalBookUseCase = new ModifyDigitalBookUseCase(digitalBookRepository, digitalBookFactory);
    }

    @AfterEach
    public void clear() {
        modifyDigitalBookUseCase = null;
    }

    @Test
    public void cuandoObtengoUnLibroDigitalEntoncesLoModifico() {
        DigitalBook digitalBook = new DigitalBook("1", null, null, null, null);
        Mockito.when(digitalBookFactory.build("1", null, null, null, null))
                .thenReturn(digitalBook);

        modifyDigitalBookUseCase.execute("1", null, null, null, null);

        Mockito.verify(digitalBookRepository, Mockito.times(1)).modifyDigitalBook(digitalBook);
    }
}
