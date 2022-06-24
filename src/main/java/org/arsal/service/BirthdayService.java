package org.arsal.service;

import org.arsal.domain.People;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BirthdayService {

    public List<People> findWhoseBirthdayIsToday(List<People> listOfPeople, LocalDate localDateToday) {
        List<People> listOfPeopleWithBirthdayToday = new ArrayList<>();
        listOfPeople.forEach(people -> {
            if (people.getBirthday().isLeapYear()) {
                if(localDateToday.isLeapYear() &&
                        people.getBirthday().getDayOfYear() == localDateToday.getDayOfYear()) {
                    listOfPeopleWithBirthdayToday.add(people);
                }

                if(!localDateToday.isLeapYear() &&
                        people.getBirthday().minusDays(1).getDayOfYear() == localDateToday.getDayOfYear()) {
                    listOfPeopleWithBirthdayToday.add(people);
                }

            } else if (people.getBirthday().getDayOfYear() == localDateToday.getDayOfYear()) {
                listOfPeopleWithBirthdayToday.add(people);
            }
        });
        return listOfPeopleWithBirthdayToday;
    }
}
