package com.iesam.digitallibrary.feature.digitalbook.domain;

import java.util.List;

public class GetAllDigitalBooksUseCase {
    private DigitalBookRepository digitalBookRepository;
    public GetAllDigitalBooksUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public List<DigitalBook> execute () {
       return digitalBookRepository.getAllDigitalBooks();
    }
}
