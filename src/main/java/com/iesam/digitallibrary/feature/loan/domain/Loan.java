package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public final String id;
    public final User user;
    public final DigitalBook digitalBook;
    public final String loanInitialDate;
    public final String returnDate;
    public final Boolean finalized;

    public Loan(User user, DigitalBook digitalBook, Boolean finalized) {
        this.id = idCreator();
        this.user = user;
        this.digitalBook = digitalBook;
        this.loanInitialDate = getCurrentDate();
        this.returnDate = getReturnDate();
        this.finalized = finalized;
    }

    public Loan(String id, User user, DigitalBook digitalBook, String loanInitialDate, String returnDate, Boolean finalized) {
        this.id = id;
        this.user = user;
        this.digitalBook = digitalBook;
        this.loanInitialDate = loanInitialDate;
        this.returnDate = returnDate;
        this.finalized = finalized;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "ID='" + id + '\'' +
                ", Usuario=" + user +
                ", Libro digital=" + digitalBook +
                ", Fecha de prestamo='" + loanInitialDate + '\'' +
                ", Fecha de devolución='" + returnDate + '\'' +
                ", ¿Finalizado?=" + finalized +
                '}';
    }

    private String idCreator() {
        long timeStamp = Instant.now().getEpochSecond();
        return "ID_" + timeStamp;
    }

    private String getCurrentDate() {
        return LocalDate.now().format(FORMATTER);
    }

    private String getReturnDate() {
       return LocalDate.parse(loanInitialDate, FORMATTER).plusDays(15).format(FORMATTER);
    }

}
