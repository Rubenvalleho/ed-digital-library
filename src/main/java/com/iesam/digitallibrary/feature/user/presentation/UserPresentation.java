package com.iesam.digitallibrary.feature.user.presentation;

import com.iesam.digitallibrary.feature.user.data.UserDataRepository;
import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.CreateUserUseCase;
import com.iesam.digitallibrary.feature.user.domain.User;

public class UserPresentation {
    public static void addUser(String userCode, String dni, String name, String lastName, String phoneNumber, String address) {
        UserDataRepository userDataRepository = new UserDataRepository(new UserFileLocalDataSource());
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userDataRepository);

        User user = new User(userCode, dni, name, lastName, phoneNumber, address);

        createUserUseCase.execute(user);
    }
}
