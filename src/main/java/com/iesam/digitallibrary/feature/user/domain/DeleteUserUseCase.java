package com.iesam.digitallibrary.feature.user.domain;

public class DeleteUserUseCase {
    private UserRepository userRepository;

    public DeleteUserUseCase (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute (String userCode) {
        userRepository.deleteUser(userCode);
    }
}
