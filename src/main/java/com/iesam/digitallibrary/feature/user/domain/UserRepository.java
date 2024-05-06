package com.iesam.digitallibrary.feature.user.domain;

import java.util.ArrayList;

public interface UserRepository {
    public void saveUser(User user);
    public User getUser (String userCode);
    public ArrayList<User> getUsers();
    public void modifyUser (User user);
    public void deleteUser (String userCode);
}
