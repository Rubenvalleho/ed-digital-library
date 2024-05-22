package com.iesam.digitallibrary.feature.digitalbook.domain;

public class ModifyDigitalBookUseCase {
    private DigitalBookRepository digitalBookRepository;
    private DigitalBookFactory digitalBookFactory;
    public ModifyDigitalBookUseCase(DigitalBookRepository digitalBookRepository, DigitalBookFactory digitalBookFactory) {
        this.digitalBookRepository = digitalBookRepository;
        this.digitalBookFactory = digitalBookFactory;
    }

    public void execute (String id, String title, String author, String editorial, String releaseDate) {
        DigitalBook digitalBook = digitalBookFactory.build(id, title, author, editorial, releaseDate);
        digitalBookRepository.modifyDigitalBook(digitalBook);
    }
}
