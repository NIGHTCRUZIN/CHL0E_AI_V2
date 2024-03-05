package org.nightcruzin.chl0e;

import java.util.HashMap;
import java.util.Map;

public class SelfLearning {
    private Map<String, String> learnedResponses;

    public SelfLearning() {
        learnedResponses = new HashMap<>();
    }

    public void learnFromConversation(String userInput, String aiResponse) {
        // Store the AI's response along with the user input
        learnedResponses.put(userInput.toLowerCase(), aiResponse);
    }

    public String getUserResponse(String userInput) {
        // Retrieve the AI's response based on the user input
        return learnedResponses.get(userInput.toLowerCase());
    }

    // Other methods for managing user preferences...
}





