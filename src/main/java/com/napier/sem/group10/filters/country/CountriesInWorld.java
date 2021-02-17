package com.napier.sem.group10.filters.country;

import com.napier.sem.group10.CountryCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * All the countries in the world organised by largest population to smallest.
 */
public class CountriesInWorld extends CountryCommandHandler {
    @Override
    public String getCommand() {
        return "country1";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY population DESC LIMIT ?;");
        int limit = Integer.parseInt(args.getOrDefault("limit", "9999999"));
        statement.setInt(1, limit);
        return statement;
    }
}



