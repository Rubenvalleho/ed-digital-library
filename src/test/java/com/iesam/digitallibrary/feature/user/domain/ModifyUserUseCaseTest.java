package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ModifyUserUseCaseTest {

    @Mock
    UserRepository userRepository;

    ModifyUserUseCase modifyUserUseCase;

    @BeforeEach
    public void setUp() {
        modifyUserUseCase = new ModifyUserUseCase(userRepository);
    }

    @AfterEach
    public void clear() {
        modifyUserUseCase = null;
    }

    @Test
    public void obtengoUnUsuarioExistenteYLoModifico() {
        User user = new User("1",null,null,null,null,null);

        modifyUserUseCase.execute(user);

        Mockito.verify(userRepository, Mockito.times(1)).modifyUser(user);
    }
}
