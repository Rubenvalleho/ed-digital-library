package com.iesam.digitallibrary.feature.user.domain;

public class CreateUserUseCase {
    UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute (User user) {
        userRepository.saveUser(user);
    }
}
