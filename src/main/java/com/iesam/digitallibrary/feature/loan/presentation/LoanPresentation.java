package com.iesam.digitallibrary.feature.loan.presentation;

import com.iesam.digitallibrary.feature.digitalbook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookMemLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalbook.domain.GetDigitalBookUseCase;
import com.iesam.digitallibrary.feature.loan.data.LoanDataRepository;
import com.iesam.digitallibrary.feature.loan.data.local.LoanFileLocalDataSource;
import com.iesam.digitallibrary.feature.loan.data.local.LoanMemLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.*;
import com.iesam.digitallibrary.feature.user.data.UserDataRepository;
import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("4. Visualizar prestamo.");
            System.out.println("5. Visualizar prestamos finalizados.");
            System.out.println("6. Visualizar prestamos en curso.");
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
                case 5:
                    getFinalizedLoans();
                    break;
                case 6:
                    getNotFinalizedLoans();
                    break;
            }
        } while (choice != 0);
    }

    public static void addLoan() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource(),
                LoanMemLocalDataSource.getInstance());
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource(),
                UserMemLocalDataSource.getInstance());
        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(
                new DigitalBookFileLocalDataSource(), DigitalBookMemLocalDataSource.getInstance());
        LoanFactory loanFactory = new LoanFactory();
        CreateLoanUseCase createLoanUseCase = new CreateLoanUseCase(loanDataRepository, loanFactory, userDataRepository,
                digitalBookDataRepository);

        System.out.println("Inserta el codigo de usuario que solicita el prestamo.");
        String userCode = scanner.next();
        System.out.println("Inserta el ID del libro digital solicitado.");
        String digitalBookId = scanner.next();

        createLoanUseCase.execute(userCode, digitalBookId);
        System.out.println("Prestamo concedido con exito.");
    }

    public static void deleteLoan() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource(),
                LoanMemLocalDataSource.getInstance());
        DeleteLoanUseCase deleteLoanUseCase = new DeleteLoanUseCase(loanDataRepository);

        System.out.println("Introduce el ID del prestamo a eliminar.");
        String loanId = scanner.next();

        deleteLoanUseCase.execute(loanId);
        System.out.println("Prestamo eliminado con exito.");
    }

    public static void finishLoan() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource(),
                LoanMemLocalDataSource.getInstance());
        LoanFactory loanFactory = new LoanFactory();
        FinishLoanUseCase finishLoanUseCase = new FinishLoanUseCase(loanDataRepository, loanFactory);

        System.out.println("Inserta el ID del préstamo a finalizar.");
        String id = scanner.next();

        finishLoanUseCase.execute(id);
        System.out.println("Prestamo finalizado.");
    }

    public static void getLoan() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource(),
                LoanMemLocalDataSource.getInstance());
        GetLoanUseCase getLoanUseCase = new GetLoanUseCase(loanDataRepository);

        System.out.println("Introduce el ID del fichero a visualizar");
        String id = scanner.next();

        Loan loan = getLoanUseCase.execute(id);

        if (loan == null) {
            System.err.println("No existe ningún prestamo con ese ID");
        } else {
            System.out.println(loan);
        }
    }

    public static void getFinalizedLoans() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource(),
                LoanMemLocalDataSource.getInstance());
        GetFinalizedLoansUseCase getFinalizedLoansUseCase = new GetFinalizedLoansUseCase(loanDataRepository);

        List<Loan> finalizedLoans = getFinalizedLoansUseCase.execute();

        if (finalizedLoans == null) {
            System.err.println("No hay ningún prestamo finalizado actualmente.");
        } else {
            for (Loan loan : finalizedLoans) {
                System.out.println(loan);
            }
        }

    }

    public static void getNotFinalizedLoans() {
        LoanDataRepository loanDataRepository = new LoanDataRepository(new LoanFileLocalDataSource(),
                LoanMemLocalDataSource.getInstance());
        GetNotFinalizedLoansUseCase getNotFinalizedLoansUseCase = new GetNotFinalizedLoansUseCase(loanDataRepository);

        List<Loan> notFinalizedLoans = getNotFinalizedLoansUseCase.execute();

        if (notFinalizedLoans == null) {
            System.err.println("No hay prestamos no finalizados actualmente.");
        } else {
            for (Loan loan : notFinalizedLoans) {
                System.out.println(loan);
            }
        }

    }
}
