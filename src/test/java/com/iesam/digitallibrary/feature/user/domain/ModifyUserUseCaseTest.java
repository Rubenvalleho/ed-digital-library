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

    @Mock
    UserFactory userFactory;

    ModifyUserUseCase modifyUserUseCase;

    @BeforeEach
    public void setUp() {
        modifyUserUseCase = new ModifyUserUseCase(userRepository, userFactory);
    }

    @AfterEach
    public void clear() {
        modifyUserUseCase = null;
    }

    @Test
    public void obtengoUnUsuarioExistenteYLoModifico() {
        User user = new User("001", null, null, null, null, null);
        Mockito.when(userFactory.build("001", null, null, null, null,
                null)).thenReturn(user);

        modifyUserUseCase.execute("001", null, null, null, null, null);

        Mockito.verify(userRepository, Mockito.times(1)).modifyUser(user);
    }
}
