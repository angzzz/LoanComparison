package com.anjaleeps.loancomparison;

import android.content.SearchRecentSuggestionsProvider;

public class SampleRecentSuggestionProvider extends SearchRecentSuggestionsProvider {

    public static final String AUTHORITY =
            SampleRecentSuggestionProvider.class.getName();

    public static final int MODE = DATABASE_MODE_QUERIES;

    public SampleRecentSuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}