package com.napier.sem.group10.filters.population;

import com.napier.sem.group10.CountryCommandHandler;
import com.napier.sem.group10.CountPopCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class WorldPop extends CountPopCommandHandler {

    @Override
    public String getCommand() {
        return "population9";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT 'World' as Name, SUM(population) as Population FROM country");

        return statement;
    }
}