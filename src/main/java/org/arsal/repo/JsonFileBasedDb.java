package org.arsal.repo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.arsal.domain.People;
import org.arsal.utility.LocalDateAdapterUtility;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class JsonFileBasedDb implements DataBase {

    @Override
    public List<People> loadData(String fileName) throws IOException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapterUtility().nullSafe()).create();
        List<People> listOfPeople;
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName))) {
            listOfPeople = gson.fromJson(reader, new TypeToken<List<People>>() {
            }.getType());
        }
        return listOfPeople;
    }
}
