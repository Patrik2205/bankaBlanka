package org.delta.persons;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.BankAccountNumberGenerator;

@Singleton
public class OwnerFactory {

    @Inject
    PersonIdValidator validator;

    @Inject
    BankAccountNumberGenerator bankAccountNumberGenerator;

    public Owner createOwner(String name, String lastName, int personId) {

        if(!this.validator.isPersonIdValid(personId)) {
            System.out.println("Invalid person id: " + personId);
        }

        return new Owner(name, lastName, personId);
    }

}
