package org.arsal.service;

import org.arsal.domain.People;
import org.arsal.repo.DataBase;
import org.arsal.repo.JsonFileBasedDb;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BirthdayServiceTest {

    private static final String FILE_PATH = "/src/test/resources/input-test.json";
    private static final String DATE_FORMAT_PATTERN = "yyyy/MM/dd";
    private final DataBase dataBase = new JsonFileBasedDb();
    private final BirthdayService birthdayService = new BirthdayService();
    private List<People> listOfPeopleFromDb;

    @Before
    public void setUp() throws IOException {
        String fileName = new File(".").getCanonicalPath() + FILE_PATH;
        listOfPeopleFromDb = dataBase.loadData(fileName);
    }

    @Test
    public void testFindWhoseBirthdayIsTodayWithNoOnesBirthdayToday() {
        List<People> expectedListOfPeople = new ArrayList<>();

        LocalDate localDateToday = LocalDate.parse("2022/01/10", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
        List<People> actualListOfPeople = birthdayService.findWhoseBirthdayIsToday(listOfPeopleFromDb, localDateToday);

        Assert.assertEquals(expectedListOfPeople, actualListOfPeople);
    }

    @Test
    public void testFindWhoseBirthdayIsTodayWithDate2022_03_28() {
        List<People> expectedListOfPeople = new ArrayList<>();
        expectedListOfPeople.add(new People("Gaga", "Lady",
                LocalDate.parse("1986/03/28", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));
        expectedListOfPeople.add(new People("John", "Baker",
                LocalDate.parse("1986/03/28", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));

        LocalDate localDateToday = LocalDate.parse("2022/03/28", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
        List<People> actualListOfPeople = birthdayService.findWhoseBirthdayIsToday(listOfPeopleFromDb, localDateToday);

        Assert.assertEquals(expectedListOfPeople, actualListOfPeople);
    }

    @Test
    public void testFindWhoseBirthdayIsTodayWithDate2024_02_29() {
        List<People> expectedListOfPeople = new ArrayList<>();
        expectedListOfPeople.add(new People("Curry", "Mark",
                LocalDate.parse("1988/02/29", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));

        LocalDate localDateToday = LocalDate.parse("2024/02/29", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
        List<People> actualListOfPeople = birthdayService.findWhoseBirthdayIsToday(listOfPeopleFromDb, localDateToday);

        Assert.assertEquals(expectedListOfPeople, actualListOfPeople);
    }

    @Test
    public void testFindWhoseBirthdayIsTodayWithDate2022_02_28() {
        List<People> expectedListOfPeople = new ArrayList<>();
        expectedListOfPeople.add(new People("Curry", "Mark",
                LocalDate.parse("1988/02/29", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN))));

        LocalDate localDateToday = LocalDate.parse("2022/02/28", DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
        List<People> actualListOfPeople = birthdayService.findWhoseBirthdayIsToday(listOfPeopleFromDb, localDateToday);

        Assert.assertEquals(expectedListOfPeople, actualListOfPeople);
    }
}
