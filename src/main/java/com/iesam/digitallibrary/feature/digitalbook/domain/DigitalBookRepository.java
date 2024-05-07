package com.iesam.digitallibrary.feature.digitalbook.domain;

public interface DigitalBookRepository {
    void saveDigitalBook(DigitalBook digitalBook);
    DigitalBook getDigitalBook(String id);
    void deleteDigitalBook(String id);
    void modifyDigitalBook(DigitalBook digitalBook);
}
