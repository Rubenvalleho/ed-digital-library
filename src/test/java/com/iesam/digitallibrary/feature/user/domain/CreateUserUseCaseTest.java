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

    @Mock
    UserFactory userFactory;

    CreateUserUseCase createUserUseCase;

    @BeforeEach
    public void setUp() {
        createUserUseCase = new CreateUserUseCase(userRepository, userFactory);
    }

    @AfterEach
    public void clear() {
        createUserUseCase = null;
    }

    @Test
    public void reciboUnUsuarioYEjecutoElMetodoAddUserParaGuardarlo() {
        User user = new User("001", null, null, null, null, null);
        Mockito.when(userFactory.build("001", null, null, null, null,
                null)).thenReturn(user);

        createUserUseCase.execute("001", null, null, null, null, null);

        Mockito.verify(userRepository, Mockito.times(1)).saveUser(user);
    }

}
