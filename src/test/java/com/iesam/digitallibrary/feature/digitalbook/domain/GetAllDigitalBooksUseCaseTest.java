package com.iesam.digitallibrary.feature.digitalbook.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GetAllDigitalBooksUseCaseTest {

    @Mock
    DigitalBookRepository digitalBookRepository;

    GetAllDigitalBooksUseCase getAllDigitalBooksUseCase;

    @BeforeEach
    public void setUp() {
        getAllDigitalBooksUseCase = new GetAllDigitalBooksUseCase(digitalBookRepository);
    }

    @AfterEach
    public void clear() {
        getAllDigitalBooksUseCase = null;
    }

    @Test
    public void cuandoSeLlamaAlCasoDeUsoEntoncesObtengoLaListaCompletaDeLibrosDigitales() {
        DigitalBook digitalBook1 = new DigitalBook("1", null, null, null, null);
        DigitalBook digitalBook2 = new DigitalBook("2", null, null, null, null);

        List<DigitalBook> listExpected = new ArrayList<>();
        listExpected.add(digitalBook1);
        listExpected.add(digitalBook2);

        Mockito.when(digitalBookRepository.getAllDigitalBooks()).thenReturn(listExpected);

        List<DigitalBook> listReceived = getAllDigitalBooksUseCase.execute();

        Assertions.assertEquals(listReceived.size(), listExpected.size());
        Assertions.assertEquals(listReceived.get(0).id,"1");
        Assertions.assertEquals(listReceived.get(1).id,"2");
    }
}
