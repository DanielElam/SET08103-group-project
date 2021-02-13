package com.napier.sem.group10;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class PopulationCommandHandler implements ICommandHandler {
    /**
     * For the population reports, the following information is requested:
     *  The name of the continent/region/country.
     *  The total population of the continent/region/country.
     *  The total population of the continent/region/country living in cities (including a %).
     *  The total population of the continent/region/country not living in cities (including a %).
     * @param set The SQL result set
     * @return Relevant columns
     */
    @Override
    public String getResultRow(ResultSet set) throws SQLException {
        String name = set.getString("Name");
        int population = set.getInt("Population");
        String populationLivingInCities = set.getString("PopulationLivingInCities");
        String populationNotLivingInCities = set.getString("PopulationNotLivingCities");
        return String.format("\"%s\",\"%s\",%d", name, population, populationLivingInCities, populationNotLivingInCities);
    }
}
