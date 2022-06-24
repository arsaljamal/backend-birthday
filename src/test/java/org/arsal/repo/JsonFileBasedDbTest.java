package org.arsal.repo;

import org.arsal.domain.People;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JsonFileBasedDbTest {

    private static final String FILE_PATH = "/src/test/resources/input-test.json";
    private static final String DATE_FORMAT_PATTERN = "yyyy/MM/dd";
    private final DataBase dataBase = new JsonFileBasedDb();

    @Test
    public void testLoadData() throws IOException {
        List<People> expectedListOfPeople = new ArrayList<>();
        expectedListOfPeople.add(new People("Doe", "John",
                LocalDate.parse("1982/10/08", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));
        expectedListOfPeople.add(new People("Wayne", "Bruce",
                LocalDate.parse("1965/01/30", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));
        expectedListOfPeople.add(new People("Gaga", "Lady",
                LocalDate.parse("1986/03/28", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));
        expectedListOfPeople.add(new People("John", "Baker",
                LocalDate.parse("1986/03/28", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));
        expectedListOfPeople.add(new People("Curry", "Mark",
                LocalDate.parse("1988/02/29", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));

        String fileName = new File(".").getCanonicalPath() + FILE_PATH;

        List<People> actualListOfPeople = dataBase.loadData(fileName);
        Assert.assertEquals(expectedListOfPeople, actualListOfPeople);
    }
}
