import com.iesam.digitallibrary.feature.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        verMenu();
    }

    public static void verMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n| Biblioteca digital |");
            System.out.println("----------------------");
            System.out.println("1. Añadir usuario.");
            System.out.println("2. Visualizar usuario.");
            System.out.println("3. Visualizar la lista completa de usuarios registrados.");
            System.out.println("4. Modificar usuario.");
            System.out.println("5. Eliminar usuario.");
            System.out.println("10. Salir.");
            System.out.println("Elige una opción: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    UserPresentation.addUser();
                    System.out.println("Usuario creado.");
                    break;
                case 2:
                    UserPresentation.viewUser();
                    break;
                case 3:
                    UserPresentation.getUsersList();
                    break;
                case 4:
                    UserPresentation.modifyUser();
                    break;
                case 5:
                    UserPresentation.deleteUser();
            }
        }
        while (choice != 10);
    }
}