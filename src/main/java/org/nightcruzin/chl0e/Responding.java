package org.nightcruzin.chl0e;

public class Responding {
    private Database database;
    private WebScrapping webScrapping;
    private SelfLearning selfLearning;
    private LanguageConfiguration languageConfiguration;

    public Responding(Database database, WebScrapping webScrapping, SelfLearning selfLearning, LanguageConfiguration languageConfiguration) {
        this.database = database;
        this.webScrapping = webScrapping;
        this.selfLearning = selfLearning;
        this.languageConfiguration = languageConfiguration;
    }

    public String generateResponse(String userInput) {
        // Pre-process user input based on language configuration
        userInput = languageConfiguration.preProcess(userInput);

        // Check if the user input contains any keywords related to web scraping
        if (webScrapping.isWebScrapingEnabled() && languageConfiguration.shouldScrapeInformation(userInput)) {
            String scrapedInfo = webScrapping.scrapeInformation(userInput);
            if (scrapedInfo != null) {
                return scrapedInfo;
            }
        }

        // Check if the user input matches any stored responses in the database
        String dbResponse = database.getResponse(userInput);
        if (dbResponse != null) {
            return dbResponse;
        }

        // Learn from the conversation
        selfLearning.learnFromConversation(userInput, generateGenericResponse());

        // Check if the AI has learned any responses from previous conversations
        String learnedResponse = selfLearning.getUserResponse(userInput);
        if (learnedResponse != null) {
            return learnedResponse;
        }

        // Generate a generic response if no specific response is found
        return generateGenericResponse();
    }

    private String generateGenericResponse() {
        // Generate a generic response based on language configuration
        return languageConfiguration.generateGenericResponse();
    }
}


