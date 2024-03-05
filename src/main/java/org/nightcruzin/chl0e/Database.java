package org.nightcruzin.chl0e;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, String> data;

    public Database() {
        this.data = new HashMap<>();
    }

    public String getResponse(String userInput) {
        return data.get(userInput.toLowerCase());
    }

    // Method to insert data into the database
    public void insert(String key, String value) {
        data.put(key, value);
    }

    // Method to retrieve data from the database
    public String get(String key) {
        return data.get(key);
    }

    // Method to check if a key exists in the database
    public boolean containsKey(String key) {
        return data.containsKey(key);
    }

    // Method to remove data from the database
    public void remove(String key) {
        data.remove(key);
    }

    // Method to get all keys in the database
    public Iterable<String> getAllKeys() {
        return data.keySet();
    }

    // Method to get the size of the database
    public int size() {
        return data.size();
    }
    public void storeConversation(String userInput, String response) {
        // Logic to store the conversation in the database
        // For example:
        // data.put(userInput, response);
        // saveDataToFile();
    }

}

