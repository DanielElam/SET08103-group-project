package com.napier.sem.group10.filters.country;

import com.napier.sem.group10.CountryCommandHandler;

/**
 * The top N populated countries in the world where N is provided by the user.
 */
public class TopNCountriesInWorld extends CountryCommandHandler {
    @Override
    public String getCommand() { return "country4-n"; }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
