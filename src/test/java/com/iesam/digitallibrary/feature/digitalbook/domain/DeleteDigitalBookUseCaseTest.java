package com.iesam.digitallibrary.feature.digitalbook.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeleteDigitalBookUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;

    DeleteDigitalBookUseCase deleteDigitalBookUseCase;

    @BeforeEach
    public void setUp() {
        deleteDigitalBookUseCase = new DeleteDigitalBookUseCase(digitalBookRepository);
    }

    @AfterEach
    public void clear() {
        deleteDigitalBookUseCase = null;
    }

    @Test
    public void cuandoReciboUnCodigoEntoncesEliminoElObjetoAlQueHaceReferencia() {
        String digitalBookId = "1";

        deleteDigitalBookUseCase.execute(digitalBookId);

        Mockito.verify(digitalBookRepository, Mockito.times(1)).deleteDigitalBook(digitalBookId);
    }
}
