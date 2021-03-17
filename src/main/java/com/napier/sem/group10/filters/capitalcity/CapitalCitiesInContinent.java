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
        PreparedStatement statement = connection.prepareStatement("<TODO>");
        statement.setString(0, args.getOrDefault("limit", "9999999"));
        return statement;
    }
}
