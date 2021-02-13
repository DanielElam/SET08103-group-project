package com.napier.sem.group10.filters.country;

import com.napier.sem.group10.CountryCommandHandler;

/**
 * All the countries in the world organised by largest population to smallest.
 */
public class CountriesInWorldOrganisedByLargestPopToSmallest extends CountryCommandHandler {
    @Override
    public String getCommand() {
        return "country1";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return "SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY population DESC;";
    }
}



