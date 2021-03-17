package com.napier.sem.group10.filters.capitalcity;

import com.napier.sem.group10.CapitalCityCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * All the capital cities in a region organised by largest to smallest.
 */
public class CapitalCitiesInRegion extends CapitalCityCommandHandler {
    @Override
    public String getCommand() {
        return "capitalcity3";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("<TODO>");
        statement.setString(0, args.getOrDefault("limit", "9999999"));
        return statement;
    }
}
