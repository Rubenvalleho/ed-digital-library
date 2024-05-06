package com.iesam.digitallibrary.feature.digitalbook.domain;

public class GetDigitalBookUseCase {
    private DigitalBookRepository digitalBookRepository;
    public GetDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public DigitalBook execute(String id) {
        return digitalBookRepository.getDigitalBook(id);
    }
}
