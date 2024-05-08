package com.iesam.digitallibrary.feature.loan.data.local;

import com.iesam.digitallibrary.feature.loan.domain.Loan;

import java.util.List;

public interface LoanLocalDataSource {
    public void save(Loan model);
    public void saveList(List<Loan> models);
    public Loan findById(String id);
    public List<Loan> findAll();
    public void delete(String modelId);
    public void modify(Loan loan);
}
