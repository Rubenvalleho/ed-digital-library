package com.iesam.digitallibrary.feature.digitalbook.domain;

public class CreateDigitalBookUseCase {
    private DigitalBookRepository digitalBookRepository;
    private DigitalBookFactory digitalBookFactory;

    public CreateDigitalBookUseCase(DigitalBookRepository digitalBookRepository, DigitalBookFactory digitalBookFactory) {
        this.digitalBookRepository = digitalBookRepository;
        this.digitalBookFactory = digitalBookFactory;
    }

    public void execute(String id, String title, String author, String editorial, String releaseDate) {
        DigitalBook digitalBook = digitalBookFactory.build(id, title, author, editorial, releaseDate);
        digitalBookRepository.saveDigitalBook(digitalBook);
    }
}
