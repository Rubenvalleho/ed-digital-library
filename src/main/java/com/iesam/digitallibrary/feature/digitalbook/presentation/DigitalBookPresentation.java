package com.iesam.digitallibrary.feature.digitalbook.presentation;

import com.iesam.digitallibrary.feature.digitalbook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.domain.CreateDigitalBookUseCase;
import com.iesam.digitallibrary.feature.digitalbook.domain.DeleteDigitalBookUseCase;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalbook.domain.GetDigitalBookUseCase;

import java.util.Scanner;

public class DigitalBookPresentation {

    public static void menuDigitalBook() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menú de libros digitales.");
            System.out.println("-------------------------");
            System.out.println("1. Guardar libro digital.");
            System.out.println("2. Obtener libro digital.");
            System.out.println("3. Eliminar libro digital.");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    saveDigitalBook();
                    break;
                case 2:
                    getDigitalBook();
                    break;
                case 3:
                    deleteDigitalBook();
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

        DigitalBook digitalBook = new DigitalBook(id, title, author, editorial, releaseDate);
        createDigitalBookUseCase.execute(digitalBook);
    }

    public static void getDigitalBook() {
        Scanner scanner = new Scanner(System.in);
        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(new DigitalBookFileLocalDataSource());
        GetDigitalBookUseCase getDigitalBookUseCase = new GetDigitalBookUseCase(digitalBookDataRepository);

        System.out.println("Introduce el id del libro a obtener: ");
        String id = scanner.next();

        DigitalBook digitalBook = getDigitalBookUseCase.execute(id);
        System.out.println(digitalBook);
    }

    public static void deleteDigitalBook() {
        Scanner scanner = new Scanner(System.in);
        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(new DigitalBookFileLocalDataSource());
        DeleteDigitalBookUseCase deleteDigitalBookUseCase = new DeleteDigitalBookUseCase(digitalBookDataRepository);

        System.out.println("Introduce el id del libro a eliminar: ");
        String id = scanner.next();

        deleteDigitalBookUseCase.execute(id);
        System.out.println("Libro digital eliminado con exito.");

    }
}
