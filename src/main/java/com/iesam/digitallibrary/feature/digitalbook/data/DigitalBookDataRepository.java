package com.iesam.digitallibrary.feature.digitalbook.data;

import com.iesam.digitallibrary.feature.digitalbook.data.local.DigitalBookLocalDataSource;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBook;
import com.iesam.digitallibrary.feature.digitalbook.domain.DigitalBookRepository;

import java.util.List;

public class DigitalBookDataRepository implements DigitalBookRepository {
    private DigitalBookLocalDataSource fileLocalDataSource;
    private DigitalBookLocalDataSource memLocalDataSource;
    public DigitalBookDataRepository(DigitalBookLocalDataSource digitalBookFileLocalDataSource, DigitalBookLocalDataSource memLocalDataSource) {
        this.fileLocalDataSource = digitalBookFileLocalDataSource;
        this.memLocalDataSource = memLocalDataSource;
    }

    @Override
    public void saveDigitalBook(DigitalBook digitalBook) {
        fileLocalDataSource.save(digitalBook);
    }

    @Override
    public DigitalBook getDigitalBook(String id) {
        DigitalBook digitalBookFile = fileLocalDataSource.findById(id);
        DigitalBook digitalBookMem = memLocalDataSource.findById(id);

        if(digitalBookMem == null) {
            digitalBookMem = digitalBookFile;
            if (digitalBookMem != null) {
                memLocalDataSource.save(digitalBookMem);
            }
            return digitalBookFile;
        }

        if (digitalBookFile != null && !digitalBookFile.equals(digitalBookMem)) {
            memLocalDataSource.save(digitalBookFile);
            return digitalBookFile;
        }
        return digitalBookMem;
    }

    @Override
    public void deleteDigitalBook(String id) {
        fileLocalDataSource.delete(id);
    }

    @Override
    public void modifyDigitalBook(DigitalBook digitalBook) {
        fileLocalDataSource.modify(digitalBook);
    }

    @Override
    public List<DigitalBook> getAllDigitalBooks() {
        return fileLocalDataSource.findAll();
    }

}
