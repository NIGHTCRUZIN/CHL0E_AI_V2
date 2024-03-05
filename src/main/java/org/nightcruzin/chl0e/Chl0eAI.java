package org.nightcruzin.chl0e;

import java.util.Scanner;

public class Chl0eAI {
    private SelfLearning selfLearning;
    private WebScrapping webScrapping;
    private Responding responding;
    private Database database;
    private LanguageConfiguration languageConfiguration;

    public Chl0eAI() {
        // Initialize all components
        this.selfLearning = new SelfLearning();
        this.webScrapping = new WebScrapping(true);
        this.database = new Database();
        this.languageConfiguration = new LanguageConfiguration(true, true, true);
        this.responding = new Responding(database, webScrapping, selfLearning, languageConfiguration);
    }

    public static void main(String[] args) {
        // Initialize Chl0e AI
        Chl0eAI chl0eAI = new Chl0eAI();

        // Start AI interaction
        chl0eAI.startInteraction();
    }

    private void startInteraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Chl0e. How can I assist you today?");

        while (true) {
            String userInput = scanner.nextLine();
            String response = generateResponse(userInput);
            System.out.println(response);
        }
    }

    private String generateResponse(String userInput) {
        // Perform necessary pre-processing based on language configuration
        userInput = languageConfiguration.preProcess(userInput);

        // If web scraping is enabled, scrape relevant information
        if (languageConfiguration.isWebScrapingEnabled()) {
            webScrapping.scrapeInformation(userInput);
        }

        // Respond based on the input
        String response = responding.generateResponse(userInput);

        // Learn from the conversation
        selfLearning.learnFromConversation(userInput, response);

        // Store conversation in the database
        database.storeConversation(userInput, response);

        // Perform post-processing based on language configuration
        response = languageConfiguration.postProcess(response);

        return response;
    }
}
