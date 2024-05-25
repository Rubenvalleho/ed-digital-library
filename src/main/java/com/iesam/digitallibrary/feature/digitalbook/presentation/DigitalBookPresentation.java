package com.iesam.digitallibrary.feature.digitalbook.presentation;

import com.iesam.digitallibrary.feature.digitalbook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookFileLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.domain.*;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("4. Modificar libro digital.");
            System.out.println("5. Obtener todos los libros digitales.");
            System.out.println("10. Salir");
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
                case 4:
                    modifyDigitalBook();
                    break;
                case 5:
                    getAllDigitalBooks();
                    break;
            }
        } while (choice != 10);
    }

    public static void saveDigitalBook() {
        Scanner scanner = new Scanner(System.in);
        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(new DigitalBookFileLocalDataSource());
        DigitalBookFactory digitalBookFactory = new DigitalBookFactory();
        CreateDigitalBookUseCase createDigitalBookUseCase = new CreateDigitalBookUseCase(digitalBookDataRepository, digitalBookFactory);

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

        createDigitalBookUseCase.execute(id, title, author, editorial, releaseDate);
        System.out.println("Se ha guardado el libro con los datos introducidos.");
    }

    public static void getDigitalBook() {
        Scanner scanner = new Scanner(System.in);
        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(new DigitalBookFileLocalDataSource());
        GetDigitalBookUseCase getDigitalBookUseCase = new GetDigitalBookUseCase(digitalBookDataRepository);

        System.out.println("Introduce el id del libro a obtener: ");
        String id = scanner.next();

        DigitalBook digitalBook = getDigitalBookUseCase.execute(id);
        if (digitalBook == null) {
            System.err.println("No existe un libro con ese ID");
        } else {
            System.out.println(digitalBook);
        }
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

    public static void modifyDigitalBook() {
        Scanner scanner = new Scanner(System.in);
        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(
                new DigitalBookFileLocalDataSource());
        DigitalBookFactory digitalBookFactory = new DigitalBookFactory();
        ModifyDigitalBookUseCase modifyDigitalBookUseCase = new ModifyDigitalBookUseCase(
                digitalBookDataRepository, digitalBookFactory);

        System.out.println("Introduce el id del libro digital a modificar: ");
        String id = scanner.next();
        System.out.println("Introduce el titulo: ");
        String title = scanner.next();
        System.out.println("Introduce el autor: ");
        String author = scanner.next();
        System.out.println("Introduce la editorial: ");
        String editorial = scanner.next();
        System.out.println("Introduce la fecha de salida: ");
        String releaseDate = scanner.next();

        modifyDigitalBookUseCase.execute(id, title, author, editorial, releaseDate);
        System.out.println("Libro digital modificado con exito.");
    }

    public static void getAllDigitalBooks() {
        DigitalBookDataRepository digitalBookDataRepository = new DigitalBookDataRepository(new DigitalBookFileLocalDataSource());
        GetAllDigitalBooksUseCase getAllDigitalBooksUseCase = new GetAllDigitalBooksUseCase(digitalBookDataRepository);

        List<DigitalBook> allDigitalBooks = getAllDigitalBooksUseCase.execute();

        if (allDigitalBooks == null) {
            System.err.println("No tenemos ningún libro disponible en estos momentos.");
        } else {
            for (DigitalBook digitalBook : allDigitalBooks) {
                System.out.println(digitalBook);
            }
        }
    }
}
