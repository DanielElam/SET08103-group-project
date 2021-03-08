package com.napier.sem.group10.filters.capitalcity;

import com.napier.sem.group10.CapitalCityCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * All the capital cities in a continent organised by largest population to smallest.
 */
public class CapitalCitiesInContinent extends CapitalCityCommandHandler {
    @Override
    public String getCommand() {
        return "capitalcity2";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT city.Name as Name, city.Population as Population FROM country JOIN city ON city.ID = country.Capital WHERE country.Continent = ? ORDER BY population DESC LIMIT ?;");
        int limit = Integer.parseInt(args.getOrDefault("limit","9999999"));
        statement.setInt(1, limit);
        return statement;
    }
}
