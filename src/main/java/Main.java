import com.iesam.digitallibrary.feature.digitalbook.data.DigitalBookDataRepository;
import com.iesam.digitallibrary.feature.digitalbook.presentation.DigitalBookPresentation;
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
            System.out.println("2. Acceder a menú de libros digitales");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    UserPresentation.menuUsuario();
                    break;
                case 2:
                    DigitalBookPresentation.menuDigitalBook();
                    break;
            }
        } while (choice!=10);
    }

}