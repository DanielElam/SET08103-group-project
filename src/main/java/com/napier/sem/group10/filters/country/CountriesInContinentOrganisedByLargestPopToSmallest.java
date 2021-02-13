package com.napier.sem.group10.filters.country;

import com.napier.sem.group10.CountryCommandHandler;

/**
 * All the countries in a continent organised by largest population to smallest.
 */
public class CountriesInContinentOrganisedByLargestPopToSmallest extends CountryCommandHandler {
    @Override
    public String getCommand() {
        return "country2";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
