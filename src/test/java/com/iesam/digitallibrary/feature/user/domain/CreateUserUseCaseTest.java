package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoFramework;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {
    @Mock
    UserRepository userRepository;

    CreateUserUseCase createUserUseCase;

    @BeforeEach
    public void setUp() {
        createUserUseCase = new CreateUserUseCase(userRepository);
    }

    @AfterEach
    public void clear() {
        createUserUseCase = null;
    }

    @Test
    public void reciboUnUsuarioYEjecutoElMetodoAddUserParaGuardarlo() {
        User user = new User("1", "777", "Ruben", "Vallejo", "666", "Calle");

        createUserUseCase.execute(user);

        Mockito.verify(userRepository, Mockito.times(1)).saveUser(user);
    }

}
