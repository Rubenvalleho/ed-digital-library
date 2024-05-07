package com.iesam.digitallibrary.feature.digitalbook.domain;

public class ModifyDigitalBookUseCase {
    private DigitalBookRepository digitalBookRepository;
    public ModifyDigitalBookUseCase(DigitalBookRepository digitalBookRepository) {
        this.digitalBookRepository = digitalBookRepository;
    }

    public void execute (DigitalBook digitalBook) {
        digitalBookRepository.modifyDigitalBook(digitalBook);
    }
}
