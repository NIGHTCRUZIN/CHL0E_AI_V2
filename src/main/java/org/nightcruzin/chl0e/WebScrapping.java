package org.nightcruzin.chl0e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScrapping {
    private boolean webScrapingEnabled;

    public WebScrapping(boolean webScrapingEnabled) {
        this.webScrapingEnabled = webScrapingEnabled;
    }

    // Method to scrape information based on user input
    public String scrapeInformation(String userInput) {
        // Implementation of web scraping logic
        // This method should return the scraped information as a String
        return "Scraped information for: " + userInput;
    }

    // Method to check if web scraping is enabled
    public boolean isWebScrapingEnabled() {
        return webScrapingEnabled;
    }

    // Other methods for web scraping..
}


