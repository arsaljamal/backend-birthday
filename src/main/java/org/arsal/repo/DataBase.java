package org.arsal.repo;

import org.arsal.domain.People;

import java.io.IOException;
import java.util.List;

public interface DataBase {
    List<People> loadData(String fileName) throws IOException;
}
