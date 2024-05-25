package com.iesam.digitallibrary.feature.user.domain;

public class ModifyUserUseCase {
    private UserRepository userRepository;
    private UserFactory userFactory;
    public ModifyUserUseCase (UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    public void execute (String userCode, String dni, String name, String lastName, String phoneNumber, String address) {
        User user = userFactory.build(userCode, dni, name, lastName, phoneNumber, address);
        userRepository.modifyUser(user);
    }
}
