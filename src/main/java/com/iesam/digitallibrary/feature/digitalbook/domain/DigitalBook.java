package com.iesam.digitallibrary.feature.digitalbook.domain;

public class DigitalBook {
    public final String id;
    public final String title;
    public final String author;
    public final String editorial;
    public final String releaseDate;

    public DigitalBook(String id, String title, String author, String editorial, String releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "DigitalBook{" +
                "ID='" + id + '\'' +
                ", titulo='" + title + '\'' +
                ", autor='" + author + '\'' +
                ", editorial='" + editorial + '\'' +
                ", fecha de salida='" + releaseDate + '\'' +
                '}';
    }
}
