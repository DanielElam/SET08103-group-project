package com.napier.sem.group10.filters.city;

import com.napier.sem.group10.CityCommandHandler;

/**
 * All the cities in the world organised by largest population to smallest
 */
public class CitiesInWorldOrganisedByLargestPopToSmallest extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city1";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
