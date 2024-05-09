package com.iesam.digitallibrary.feature.loan.domain;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.user.domain.User;

public class Loan {
    public final String id;
    public final User user;
    public final DigitalBook digitalBook;
    public final String loanInitialDate;
    public final String returnDate;
    public final Boolean finalized;

    public Loan(String id, User user, DigitalBook digitalBook, String loanInitialDate, String loanFinalDate) {
        this.id = id;
        this.user = user;
        this.digitalBook = digitalBook;
        this.loanInitialDate = loanInitialDate;
        this.returnDate = loanFinalDate;
        this.finalized = false;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "ID='" + id + '\'' +
                ", Usuario=" + user +
                ", Libro digital=" + digitalBook +
                ", Fecha de prestamo='" + loanInitialDate + '\'' +
                ", Fecha de devolución='" + returnDate + '\'' +
                ", ¿Devuelto?=" + finalized +
                '}';
    }
}
