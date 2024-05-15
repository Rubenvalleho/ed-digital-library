package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeleteUserCaseTest {

    @Mock
    UserRepository userRepository;

    DeleteUserUseCase deleteUserUseCase;

    @BeforeEach
    public void setUp() {
        deleteUserUseCase = new DeleteUserUseCase(userRepository);
    }

    @AfterEach
    public void clear() {
        deleteUserUseCase = null;
    }

    public void obtengoUnCodigoDeUsuarioYEliminoDichoUsuario() {
        String userCodeToDelete = "1";

        deleteUserUseCase.execute(userCodeToDelete);

        Mockito.verify(userRepository, Mockito.times(1)).deleteUser(userCodeToDelete);
    }
}
