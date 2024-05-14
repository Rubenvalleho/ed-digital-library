package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetUserUseCaseTest {
    @Mock
    UserRepository userRepository;

    GetUserUseCase getUserUseCase;

    @BeforeEach
    public void setUp() {
        getUserUseCase = new GetUserUseCase(userRepository);
    }

    @AfterEach
    public void clear() {
        getUserUseCase = null;
    }

    @Test
    public void cuandoIntroduzoUnCodigoValidoObtengoUnUsuarioExistente(){
        User userExpected = new User("1", "777",
                "Ruben", "Vallejo", "666", "Calle");

        Mockito.when(userRepository.getUser("1")).thenReturn(userExpected);

        User userReceived = getUserUseCase.execute("1");

        Assertions.assertEquals(userReceived.userCode,"1");
        Assertions.assertEquals(userReceived.dni,"777");
        Assertions.assertEquals(userReceived.name,"Ruben");
        Assertions.assertEquals(userReceived.lastName,"Vallejo");
        Assertions.assertEquals(userReceived.phoneNumber,"666");
        Assertions.assertEquals(userReceived.address,"Calle");
    }

    @Test
    public void cuandoIntroduzcoUncodigoNoValidoReciboNull() {
        String notValidUserDni = "002";
        Mockito.when(userRepository.getUser("002")).thenReturn(null);

        User userReceived = getUserUseCase.execute(notValidUserDni);

        Assertions.assertNull(userReceived);
    }
}
