package org.delta.persons;

import com.google.gson.Gson;

public class OwnerJsonSerializationService {
    public String serialize(Owner owner) {

        Gson gson = new Gson();

        return gson.toJson(owner);
    }
}
