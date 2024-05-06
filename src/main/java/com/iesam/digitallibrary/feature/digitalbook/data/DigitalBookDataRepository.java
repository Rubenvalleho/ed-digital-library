package com.iesam.digitallibrary.feature.digitalbook.data;

import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBookRepository;

public class DigitalBookDataRepository implements DigitalBookRepository {
    private DigitalBookLocalDataSource digitalBookLocalDataSource;
    public DigitalBookDataRepository(DigitalBookLocalDataSource digitalBookLocalDataSource) {
        this.digitalBookLocalDataSource = digitalBookLocalDataSource;
    }

    @Override
    public void saveDigitalBook(DigitalBook digitalBook) {
        digitalBookLocalDataSource.save(digitalBook);
    }

    @Override
    public DigitalBook getDigitalBook(String id) {
        return digitalBookLocalDataSource.findById(id);
    }

    @Override
    public void deleteDigitalBook(String id) {
        digitalBookLocalDataSource.delete(id);
    }


}
