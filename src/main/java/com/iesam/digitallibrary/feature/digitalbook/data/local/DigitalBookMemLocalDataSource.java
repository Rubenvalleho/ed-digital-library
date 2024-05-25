package com.iesam.digitallibrary.feature.digitalbook.data.local;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.user.data.local.UserLocalDataSource;
import com.iesam.digitallibrary.feature.user.domain.User;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DigitalBookMemLocalDataSource implements DigitalBookLocalDataSource {

    private static DigitalBookMemLocalDataSource instance = null;

    private DigitalBookMemLocalDataSource() {
    }

    public static DigitalBookMemLocalDataSource getInstance() {
        if (instance == null) {
            instance = new DigitalBookMemLocalDataSource();
        }
        return instance;
    }

    private Map<String, DigitalBook> dataStore = new TreeMap<>();

    public void save(DigitalBook model) {
        dataStore.put(model.id, model);
    }

    public void saveList(List<DigitalBook> models) {
        for (DigitalBook digitalBook : models) {
            save(digitalBook);
        }
    }

    public DigitalBook findById(String id) {
        return dataStore.get(id);
    }

    public List<DigitalBook> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String id) {
        dataStore.remove(id);
    }

    @Override
    public void modify(DigitalBook digitalBook) {
        delete(digitalBook.id);
        save(digitalBook);
    }
}
