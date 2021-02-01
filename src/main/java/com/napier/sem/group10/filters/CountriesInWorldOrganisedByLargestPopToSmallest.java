package com.napier.sem.group10.filters;

import com.napier.sem.group10.IPopulationResult;

public class CountriesInWorldOrganisedByLargestPopToSmallest implements IPopulationResult {

    @Override
    public String getSqlStatement(String[] args) {
        return "SELECT Name, Population FROM country ORDER BY population DESC;";
    }
}
