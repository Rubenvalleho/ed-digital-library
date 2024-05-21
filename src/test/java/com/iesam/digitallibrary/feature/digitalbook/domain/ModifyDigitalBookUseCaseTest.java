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

    ModifyDigitalBookUseCase modifyDigitalBookUseCase;

    @BeforeEach
    public void setUp() {
        modifyDigitalBookUseCase = new ModifyDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    public void clear() {
        modifyDigitalBookUseCase = null;
    }

    @Test
    public void cuandoObtengoUnLibroDigitalEntoncesLoModifico() {
        DigitalBook digitalBook = new DigitalBook("1", null, null, null, null);

        modifyDigitalBookUseCase.execute(digitalBook);

        Mockito.verify(digitalBookRepository, Mockito.times(1)).modifyDigitalBook(digitalBook);
    }
}
