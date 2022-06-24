package org.arsal;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.arsal.domain.People;
import org.arsal.repo.DataBase;
import org.arsal.repo.JsonFileBasedDb;
import org.arsal.service.BirthdayService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BackendBirthdayApplication{

    private static final Logger logger = LogManager.getLogger(BackendBirthdayApplication.class);
    private static final String FILE_PATH = "/src/main/resources/input.json";

    public static void main(String[] args) throws Exception {
        try {
            DataBase dataBase = new JsonFileBasedDb();
            BirthdayService birthdayService = new BirthdayService();
            String filePath = FILE_PATH;
            if (args.length != 0 && !Objects.equals(args[0], "")) {
                filePath = args[0];
            }
            String fileName;
            try {
                fileName = new File(".").getCanonicalPath() + filePath;
            } catch (IOException e) {
                throw new Exception(e.getMessage());
            }
            List<People> listOfPeople = dataBase.loadData(fileName);
            LocalDate localDateToday = LocalDate.now();
            List<People> listOfPeopleWithBirthdayToday = birthdayService.findWhoseBirthdayIsToday(listOfPeople, localDateToday);
            logger.info("People whose birthday is on " + localDateToday + " : " + listOfPeopleWithBirthdayToday.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }

    }
}