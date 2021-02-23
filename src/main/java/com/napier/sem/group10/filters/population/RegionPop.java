package com.napier.sem.group10.filters.population;

import com.napier.sem.group10.CountryCommandHandler;
import com.napier.sem.group10.CountPopCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class RegionPop extends CountPopCommandHandler{

    @Override
    public String getCommand() {
        return "population7";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT country.Region as name, SUM(population) AS population FROM country WHERE Region = ?");
        statement.setString(1, args.get("region"));
        return statement;
    }
}