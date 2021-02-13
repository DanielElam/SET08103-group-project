package com.napier.sem.group10.filters.city;

import com.napier.sem.group10.CityCommandHandler;

/**
 * All the cities in a region organised by largest population to smallest.
 */
public class CitiesInRegionOrganisedByLargestPopToSmallest extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city3";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
