package com.iesam.digitallibrary.feature.user.domain;

public interface UserRepository {
    public void saveUser(User user);
    public User getUser (String userCode);
    public void modifyUser (User user);
}
