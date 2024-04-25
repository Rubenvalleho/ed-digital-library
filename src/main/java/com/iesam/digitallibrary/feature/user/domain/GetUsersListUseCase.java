package com.iesam.digitallibrary.feature.user.domain;

import java.util.ArrayList;

public class GetUsersListUseCase {
    private UserRepository userRepository;
    public GetUsersListUseCase (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<User> execute () {
        return userRepository.getUsers();
    }
}
