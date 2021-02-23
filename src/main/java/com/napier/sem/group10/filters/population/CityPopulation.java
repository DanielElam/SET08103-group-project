package com.napier.sem.group10.filters.population;

import com.napier.sem.group10.CityCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class CityPopulation extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "population1";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT city.Name as Name, city.Population as TotalPop FROM city WHERE city.Name = ? ");
        statement.setString(1, args.get("city"));
        return statement;
    }
}
