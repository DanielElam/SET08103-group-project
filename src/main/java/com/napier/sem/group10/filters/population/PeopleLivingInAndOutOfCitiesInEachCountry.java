package com.napier.sem.group10.filters.population;

import com.napier.sem.group10.PopulationCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * The population of people, people living in cities, and people not living in cities in each continent.
 */
public class PeopleLivingInAndOutOfCitiesInEachCountry extends PopulationCommandHandler {
    @Override
    public String getCommand() {
        return "population2";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("TODO");
        return statement;
    }
}
