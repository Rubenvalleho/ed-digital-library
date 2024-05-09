package com.iesam.digitallibrary.feature.loan.presentation;

import com.iesam.digitallibrary.feature.digitalbook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalbook.domain.GetDigitalBookUseCase;
import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.feature.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.*;
import com.iesam.digitallibrary.feature.user.data.UserDataRepository;
import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.Scanner;

public class LoanPresentation {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuLoan() {
        int choice;

        do {
            System.out.println("\nMenú de prestamos.");
            System.out.println("--------------------");
            System.out.println("1. Conceder prestamo.");
            System.out.println("2. Eliminar prestamo.");
            System.out.println("3. Finalizar prestamo.");
            System.out.println("4. Obtener prestamo.");
            System.out.println("0. Salir.");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addLoan();
                    break;
                case 2:
                    deleteLoan();
                    break;
                case 3:
                    finishLoan();
                    break;
                case 4:
                    getLoan();
                    break;
            }
        } while (choice != 0);
    }

    public static void addLoan() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(loanDataRepository);

        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        GetUserUseCase getUserUseCase = new GetUserUseCase(userDataRepository);

        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(
                new DigitalBookFileLocalDataSource());
        GetDigitalBookUseCase getDigitalBookUseCase = new GetDigitalBookUseCase(digitalBookDataRepository);

        System.out.println("Inserta el ID del prestamo.");
        String loanId = scanner.next();
        System.out.println("Inserta el codigo de usuario que solicita el prestamo.");
        String userCode = scanner.next();
        System.out.println("Inserta el ID del libro digital solicitado.");
        String digitalBookId = scanner.next();
        System.out.println("Inserta la fecha de solicitud del prestamo.");
        String initialLoanDate = scanner.next();
        System.out.println("Inserta la fecha de devolución del libro digital prestado.");
        String returnDate = scanner.next();

        User user = getUserUseCase.execute(userCode);
        DigitalBook digitalBook = getDigitalBookUseCase.execute(digitalBookId);

        Loan loan = new Loan(loanId, user, digitalBook, initialLoanDate, returnDate, true);
        createLoanUseCase.execute(loan);
        System.out.println("Prestamo concedido con exito.");
    }

    public static void deleteLoan() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(loanDataRepository);

        System.out.println("Introduce el ID del prestamo a eliminar.");
        String loanId = scanner.next();

        deleteLoanUseCase.execute(loanId);
        System.out.println("Prestamo eliminado con exito.");
    }

    public static void finishLoan() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        FinishLoanUseCase finishLoanUseCase = new FinishLoanUseCase(loanDataRepository);

        System.out.println("Inserta el ID del préstamo a finalizar.");
        String id = scanner.next();

        finishLoanUseCase.execute(id);
    }

    public static void getLoan() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource());
        GetLoanUseCase getLoanUseCase = new GetLoanUseCase(loanDataRepository);

        System.out.println("Introduce el ID del fichero a visualizar");
        String id = scanner.next();

        Loan loan = getLoanUseCase.execute(id);
        System.out.println(loan);
    }
}
