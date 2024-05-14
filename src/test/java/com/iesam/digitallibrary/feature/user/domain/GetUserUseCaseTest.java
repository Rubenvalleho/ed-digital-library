package com.iesam.digitallibrary.feature.user.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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


}
