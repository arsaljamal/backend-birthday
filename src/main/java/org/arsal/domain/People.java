package org.arsal.domain;

import java.time.LocalDate;
import java.util.Objects;

public class People {

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    public People() {
    }

    public People(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(firstName, people.firstName) && Objects.equals(lastName, people.lastName) && Objects.equals(birthday, people.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday);
    }

    @Override
    public String toString() {
        return "People{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
