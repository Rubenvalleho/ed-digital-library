package com.iesam.digitallibrary.feature.digitalbook.domain;

public class DigitalBookFactory {
    public DigitalBook build(String id, String title, String author, String editorial, String releaseDate) {
        return new DigitalBook(id, title, author, editorial, releaseDate);
    }
}
