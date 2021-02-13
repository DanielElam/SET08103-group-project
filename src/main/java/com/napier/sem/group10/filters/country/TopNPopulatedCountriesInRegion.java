package com.napier.sem.group10.filters.country;

import com.napier.sem.group10.CountryCommandHandler;

/**
 * The top N populated countries in a region where N is provided by the user.
 */
public class TopNPopulatedCountriesInRegion extends CountryCommandHandler {
    @Override
    public String getCommand() {
        return "country6-n";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
