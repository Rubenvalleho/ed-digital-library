package com.iesam.digitallibrary.feature.digitalbook.data.local;

import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;

import java.util.List;

public interface DigitalBookLocalDataSource {
    public void save(DigitalBook model);
    public void saveList(List<DigitalBook> models);
    public DigitalBook findById(String id);
    public List<DigitalBook> findAll();
    public void delete(String modelId);
    public void modify(DigitalBook book);
}
