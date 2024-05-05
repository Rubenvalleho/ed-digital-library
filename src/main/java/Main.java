import com.iesam.digitallibrary.feature.user.presentation.UserPresentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu principal");
            System.out.println("------------------");
            System.out.println("1. Acceder a menú de usuario");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    UserPresentation.menuUsuario();
                    break;
            }
        } while (choice!=10);
    }

}