package com.iesam.digitallibrary.feature.user.data.local;

import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserMemLocalDataSource implements UserLocalDataSource{

    private Map<String, User> dataStore = new TreeMap<>();

    public void save(User model) {
        dataStore.put(model.userCode, model);
    }

    public void saveList(List<User> models) {
        for (User demo : models) {
            save(demo);
        }
    }

    public User findById(String id) {
        return dataStore.get(id);
    }

    public List<User> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String userCode) {
        dataStore.remove(userCode);
    }

    @Override
    public void modify(User user) {
        delete(user.userCode);
        save(user);
    }
}
