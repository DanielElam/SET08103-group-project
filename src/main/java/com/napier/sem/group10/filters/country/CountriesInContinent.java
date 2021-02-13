package com.napier.sem.group10.filters.country;

import com.napier.sem.group10.CountryCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * All the countries in a continent organised by largest population to smallest.
 */
public class CountriesInContinent extends CountryCommandHandler {
    @Override
    public String getCommand() {
        return "country2";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("<TODO>");
        statement.setString(0, args.getOrDefault("limit", "9999999"));
        return statement;
    }
}
