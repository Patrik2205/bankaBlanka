package org.delta.persons;

public class OwnerFactory {

    private PersonIdValidator idValidator;

    public OwnerFactory(PersonIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    public Owner createOwner(String name, String lastName, int personId) {

        if(!this.idValidator.isPersonIdValid(personId)) {
            System.out.println("Invalid person id: " + personId);
        }

        return new Owner(name, lastName, personId);
    }

}
