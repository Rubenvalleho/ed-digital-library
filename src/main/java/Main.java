import com.iesam.digitallibrary.feature.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n| Biblioteca digital |");
            System.out.println("----------------------");

            System.out.println("1. Añadir usuario.");

            System.out.println("10. Salir.");
            System.out.println("Elige una opción: ");

            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("\nVamos a crear un usuario nuevo.");
                    System.out.println("Introduce el codigo de usuario: ");
                    String userCode = scanner.next();
                    System.out.println("Introduce el dni: ");
                    String dni = scanner.next();
                    System.out.println("Introduce el nombre: ");
                    String name = scanner.next();
                    System.out.println("Introduce los apellidos: ");
                    String lastName = scanner.next();
                    System.out.println("Introduce el numero de telefono: ");
                    String phoneNumber = scanner.next();
                    System.out.println("Introduce su dirección: ");
                    String address = scanner.next();

                    UserPresentation.addUser(userCode,dni,name,lastName,phoneNumber,address);

                    System.out.println("Usuario creado.");

                    break;
            }
        }
        while (choice != 10);
    }
}