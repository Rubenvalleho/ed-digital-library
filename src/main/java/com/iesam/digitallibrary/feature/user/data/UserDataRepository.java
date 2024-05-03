package com.iesam.digitallibrary.feature.user.data;

import com.iesam.digitallibrary.feature.user.data.local.UserFileLocalDataSource;
import com.iesam.digitallibrary.feature.user.data.local.UserLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.User;
import com.iesam.digitallibrary.feature.user.domain.UserRepository;

import java.util.ArrayList;

public class UserDataRepository implements UserRepository {
    UserLocalDataSource userLocalDataSource;

    public UserDataRepository (UserLocalDataSource userLocalDataSource) {
        this.userLocalDataSource = userLocalDataSource;
    }

    @Override
    public void saveUser(User user) {
        userLocalDataSource.save(user);
    }
    public User getUser (String userCode) {
        return userLocalDataSource.findById(userCode);
    }
    public void modifyUser(User user) {
        userLocalDataSource.modify(user);
    }
    public ArrayList<User> getUsers (){
        return (ArrayList<User>) userLocalDataSource.findAll();
    }
    public void deleteUser (String userCode) {
        userLocalDataSource.delete(userCode);
    }
}
