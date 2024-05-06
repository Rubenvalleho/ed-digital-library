package com.iesam.digitallibrary.feature.digitalbook.domain;

public class CreateDigitalBookUseCase {
    private DigitalBookRepository digitalBookRepository;
    public CreateDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute(DigitalBook digitalBook) {
        digitalBookRepository.saveDigitalBook(digitalBook);
    }
}
