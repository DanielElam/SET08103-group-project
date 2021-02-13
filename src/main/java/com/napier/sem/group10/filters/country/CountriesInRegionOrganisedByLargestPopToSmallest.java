package com.napier.sem.group10.filters.country;

import com.napier.sem.group10.CountryCommandHandler;

/**
 * All the countries in a region organised by largest population to smallest.
 */
public class CountriesInRegionOrganisedByLargestPopToSmallest extends CountryCommandHandler {
    @Override
    public String getCommand() {
        return "country3";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
