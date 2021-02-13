package com.napier.sem.group10.filters.city;

import com.napier.sem.group10.CityCommandHandler;
import com.napier.sem.group10.CountryCommandHandler;

/**
 * All the cities in a district organised by largest population to smallest.
 */
public class CitiesInDistrictOrganisedByLargestPopToSmallest extends CityCommandHandler {
    @Override
    public String getCommand() { return "city5"; }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}


