package org.delta.persons;

public class Owner {
    private String name;

    private String surname;

    private int personId;

    public Owner(String name, String surname, int personId) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
