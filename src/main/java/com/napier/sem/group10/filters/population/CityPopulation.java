package com.napier.sem.group10.filters.population;

import com.napier.sem.group10.CityCommandHandler;
import com.napier.sem.group10.CountPopCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class CityPopulation extends CountPopCommandHandler {
    @Override
    public String getCommand() {
        return "population4";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT city.Name as Name, city.Population as Population FROM city WHERE city.Name = ? ORDER BY Population DESC LIMIT 1");
        statement.setString(1, args.get("city"));
        return statement;
    }
}
