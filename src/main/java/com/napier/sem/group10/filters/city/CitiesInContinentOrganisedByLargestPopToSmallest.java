package com.napier.sem.group10.filters.city;

import com.napier.sem.group10.CityCommandHandler;

/**
 * All the cities in a continent organised by largest population to smallest.
 */
public class CitiesInContinentOrganisedByLargestPopToSmallest extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city2";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
