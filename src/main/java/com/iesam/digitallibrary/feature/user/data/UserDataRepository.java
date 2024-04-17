package com.iesam.digitallibrary.feature.user.data;

import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.User;
import com.iesam.digitallibrary.feature.user.domain.UserRepository;

public class UserDataRepository implements UserRepository {
    UserFileLocalDataSource userFileLocalDataSource;

    public UserDataRepository (UserFileLocalDataSource userFileLocalDataSource) {
        this.userFileLocalDataSource = userFileLocalDataSource;
    }

    @Override
    public void saveUser(User user) {
        userFileLocalDataSource.save(user);
    }
}
