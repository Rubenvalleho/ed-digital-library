package com.iesam.digitallibrary.feature.user.data;

import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.data.local.UserLocalDataSource;
import com.iesam.digitallibrary.feature.user.data.local.UserMemLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.User;
import com.iesam.digitallibrary.feature.user.domain.UserRepository;

import java.util.ArrayList;

public class UserDataRepository implements UserRepository {
    UserLocalDataSource fileLocalDataSource;
    UserLocalDataSource memLocalDataSource;

    public UserDataRepository(UserLocalDataSource fileLocalDataSource, UserLocalDataSource memLocalDataSource) {
        this.fileLocalDataSource = fileLocalDataSource;
        this.memLocalDataSource = memLocalDataSource;
    }

    @Override
    public void saveUser(User user) {
        fileLocalDataSource.save(user);
    }

    public User getUser(String userCode) {
        User userMem = memLocalDataSource.findById(userCode);
        User userFile = fileLocalDataSource.findById(userCode);

        if (userMem == null) {
            userMem = fileLocalDataSource.findById(userCode);
            if (userMem != null) {
                memLocalDataSource.save(userFile);
            }
            return userFile;
        }

        if (userFile != null && !userFile.equals(userMem)) {
            memLocalDataSource.modify(userFile);
            return userFile;
        }
        return userMem;
    }

    public void modifyUser(User user) {
        fileLocalDataSource.modify(user);
    }

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) fileLocalDataSource.findAll();
    }

    public void deleteUser(String userCode) {
        fileLocalDataSource.delete(userCode);
    }
}
