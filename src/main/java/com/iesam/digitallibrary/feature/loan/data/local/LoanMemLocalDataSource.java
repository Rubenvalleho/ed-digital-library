package com.iesam.digitallibrary.feature.loan.data.local;

import com.iesam.digitallibrary.feature.loan.data.local.LoanLocalDataSource;
import com.iesam.digitallibrary.feature.loan.domain.Loan;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LoanMemLocalDataSource implements LoanLocalDataSource {

    private static LoanMemLocalDataSource instance = null;

    private LoanMemLocalDataSource() {

    }

    public static LoanMemLocalDataSource getInstance() {
        if (instance == null) {
            instance = new LoanMemLocalDataSource();
        }
        return instance;
    }

    private Map<String, Loan> dataStore = new TreeMap<>();

    public void save(Loan model) {
        dataStore.put(model.id, model);
    }

    public void saveList(List<Loan> models) {
        for (Loan loan : models) {
            save(loan);
        }
    }

    public Loan findById(String id) {
        return dataStore.get(id);
    }

    public List<Loan> findAll() {
        return dataStore.values().stream().toList();
    }

    public void delete(String id) {
        dataStore.remove(id);
    }

    @Override
    public void modify(Loan loan) {
        delete(loan.id);
        save(loan);
    }
}
