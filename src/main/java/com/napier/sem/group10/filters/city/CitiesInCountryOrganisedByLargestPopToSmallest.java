package com.napier.sem.group10.filters.city;

import com.napier.sem.group10.CityCommandHandler;

/**
 * All the cities in a country organised by largest population to smallest.
 */
public class CitiesInCountryOrganisedByLargestPopToSmallest extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city4";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
