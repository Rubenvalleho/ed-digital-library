package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetUsersListUseCaseTest {

    @Mock
    UserRepository userRepository;

    GetUsersListUseCase getUsersListUseCase;

    @BeforeEach
    public void setUp() {
        getUsersListUseCase = new GetUsersListUseCase(userRepository);
    }

    @AfterEach
    public void clear() {
        getUsersListUseCase = null;
    }

    @Test
    public void alPedirLaListaDeUsuariosDevuelvoUnaListaConTodosLosUsuarios() {
        User user1 = new User("1", "777", "Ruben", "", "", "");
        User user2 = new User("2", "", "", "", "", "");

        ArrayList<User> listExpected = new ArrayList<>();
        listExpected.add(user1);
        listExpected.add(user2);

        Mockito.when(userRepository.getUsers()).thenReturn(listExpected);

        ArrayList<User> listReceived = getUsersListUseCase.execute();

        Assertions.assertNotNull(listReceived);
        Assertions.assertEquals("1", listReceived.get(0).userCode);
        Assertions.assertEquals("2", listReceived.get(1).userCode);
    }
}
