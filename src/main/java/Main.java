import com.iesam.digitallibrary.feature.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    }

    public static void verMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n| Biblioteca digital |");
            System.out.println("----------------------");
            System.out.println("1. Añadir usuario.");
            System.out.println("10. Salir.");
            System.out.println("Elige una opción: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    UserPresentation.addUser();
                    System.out.println("Usuario creado.");
                    break;
            }
        }
        while (choice != 10);
    }
}