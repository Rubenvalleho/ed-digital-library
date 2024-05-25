package com.iesam.digitallibrary.feature.user.presentation;

import com.iesam.digitallibrary.feature.user.data.UserDataRepository;
import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.*;

import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPresentation {
    public static void menuUsuario() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n| Menú usuario |");
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
                    addUser();
                    System.out.println("Usuario creado.");
                    break;
                case 2:
                    viewUser();
                    break;
                case 3:
                    getUsersList();
                    break;
                case 4:
                    modifyUser();
                    break;
                case 5:
                    deleteUser();
                    break;
            }
        }
        while (choice != 10);
    }
    public static void addUser() {
        Scanner scanner = new Scanner(System.in);

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

        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource(),
                UserMemLocalDataSource.getInstance());
        UserFactory userFactory = new UserFactory();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userDataRepository, userFactory);

        createUserUseCase.execute(userCode, dni, name, lastName, phoneNumber, address);
        System.out.println("Usuario añadido con exito.");
    }

    public static void viewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserta el codigo del usuario a visualizar.");
        String userCode = scanner.nextLine();

        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource(),
                UserMemLocalDataSource.getInstance());
        GetUserUseCase getUserUseCase = new GetUserUseCase(userDataRepository);

        User user = getUserUseCase.execute(userCode);

        if (user == null) {
            System.err.println("No existe un usuario con ese ID");
        } else {
            System.out.println(user);
        }

    public static void getUsersList() {
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource(),
                UserMemLocalDataSource.getInstance());
        GetUsersListUseCase getUsersListUseCase = new GetUsersListUseCase(userDataRepository);

        ArrayList<User> users = getUsersListUseCase.execute();

        if (users == null) {
            System.err.println("No hay ningún usuario registrado.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }

    public static void modifyUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a modificar un usuario.");
        System.out.println("Dime el codigo del usuario a modificar.");
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

        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource(),
                UserMemLocalDataSource.getInstance());
        UserFactory userFactory = new UserFactory();
        ModifyUserUseCase modifyUserUseCase = new ModifyUserUseCase(userDataRepository, userFactory);

        modifyUserUseCase.execute(userCode, dni, name, lastName, phoneNumber, address);
    }

    public static void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el codigo de usuario del usuario que quieras eliminar. ");
        String userCode = scanner.next();

        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource(),
                UserMemLocalDataSource.getInstance());
        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(userDataRepository);
        deleteUserUseCase.execute(userCode);
        System.out.println("Usuario eliminado con exito.");
    }
}
