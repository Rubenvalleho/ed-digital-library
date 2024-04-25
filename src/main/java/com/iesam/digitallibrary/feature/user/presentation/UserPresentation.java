package com.iesam.digitallibrary.feature.user.presentation;

import com.iesam.digitallibrary.feature.user.data.UserDataRepository;
import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.CreateUserUseCase;
import com.iesam.digitallibrary.feature.user.domain.GetUserUseCase;
import com.iesam.digitallibrary.feature.user.domain.GetUsersListUseCase;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPresentation {
    public static void addUser() {
        Scanner scanner = new Scanner (System.in);

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

        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userDataRepository);

        User user = new User(userCode, dni, name, lastName, phoneNumber, address);

        createUserUseCase.execute(user);
    }

    public static void viewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserta el codigo del usuario a visualizar.");
        String userCode = scanner.nextLine();

        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        GetUserUseCase getUserUseCase = new GetUserUseCase(userDataRepository);

        User user = getUserUseCase.execute(userCode);

        System.out.println(user);
    }

    public static void getUsersList() {
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        GetUsersListUseCase getUsersListUseCase = new GetUsersListUseCase(userDataRepository);

        ArrayList<User> users = getUsersListUseCase.execute();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
