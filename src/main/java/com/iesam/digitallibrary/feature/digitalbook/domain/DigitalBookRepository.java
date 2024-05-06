package com.iesam.digitallibrary.feature.digitalbook.domain;

public interface DigitalBookRepository {
    void saveDigitalBook(DigitalBook digitalBook);
    DigitalBook getDigitalBook(String id);
}
