package com.napier.sem.group10.filters.city;

import com.napier.sem.group10.CityCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * All the cities in a country organised by largest population to smallest.
 */
public class CitiesInCountry extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city4";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("<TODO>");
        statement.setString(0, args.getOrDefault("limit", "9999999"));
        return statement;
    }
}