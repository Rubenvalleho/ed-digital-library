package com.iesam.digitallibrary.feature.digitalbook.presentation;

import com.iesam.digitallibrary.feature.digitalbook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.domain.CreateDigitalBookUseCase;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;

import java.util.Scanner;

public class DigitalBookPresentation {

    public static void menuDigitalBook() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menú de libros digitales.");
            System.out.println("-------------------------");
            System.out.println("1. Guardar libro digital.");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                  saveDigitalBook();
                  break;
            }
        } while (choice != 10);
    }

    public static void saveDigitalBook() {
        Scanner scanner = new Scanner(System.in);
        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(new DigitalBookFileLocalDataSource());
        CreateDigitalBookUseCase createDigitalBookUseCase = new CreateDigitalBookUseCase(digitalBookDataRepository);

        System.out.println("Introduce el id del libro: ");
        String id = scanner.next();
        System.out.println("Introduce el titulo del libro: ");
        String title = scanner.next();
        System.out.println("Introduce el autor: ");
        String author = scanner.next();
        System.out.println("Introduce la editorial: ");
        String editorial = scanner.next();
        System.out.println("Introduce la fecha de salida del libro: ");
        String releaseDate = scanner.next();

        DigitalBook digitalBook = new DigitalBook(id,title,author,editorial,releaseDate);
        createDigitalBookUseCase.execute(digitalBook);
    }
}
