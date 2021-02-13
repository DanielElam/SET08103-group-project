package com.napier.sem.group10.filters.country;

import com.napier.sem.group10.CountryCommandHandler;

/**
 * The top N populated countries in a continent where N is provided by the user.
 */
public class TopNCountriesInContinent extends CountryCommandHandler {
    @Override
    public String getCommand() {
        return "country5-n";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
