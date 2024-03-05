package org.nightcruzin.chl0e;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TextDatabase {
    private final String filePath;

    public TextDatabase(String filePath) {
        this.filePath = filePath;
    }

    public void storeConversation(String userInput, String aiResponse) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(userInput + "," + aiResponse);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResponse(String userInput) {
        Map<String, String> conversations = readConversations();
        return conversations.get(userInput);
    }

    private Map<String, String> readConversations() {
        Map<String, String> conversations = new HashMap<>();
        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                conversations.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conversations;
    }
}

