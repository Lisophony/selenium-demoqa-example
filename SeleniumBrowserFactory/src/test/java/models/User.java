package models;

import java.util.Objects;

public class User {
    private final String firstName;
    private final String lastName;
    private final String age;
    private final String email;
    private final String salary;
    private final String department;

    public User(String firstName, String lastName, String age, String email, String salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName())
                && getAge().equals(user.getAge()) && getEmail().equals(user.getEmail())
                && getSalary().equals(user.getSalary()) && getDepartment().equals(user.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge(), getEmail(), getSalary(), getDepartment());
    }
}
