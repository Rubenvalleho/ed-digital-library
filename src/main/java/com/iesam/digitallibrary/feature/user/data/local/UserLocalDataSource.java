package com.iesam.digitallibrary.feature.user.data.local;

import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.List;

public interface UserLocalDataSource {
    public void save(User model);
    public void saveList(List<User> models);
    public User findById(String id);
    public List<User> findAll();
    public void delete(String modelId);
}
