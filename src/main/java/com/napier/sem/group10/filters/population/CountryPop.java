package com.napier.sem.group10.filters.population;

import com.napier.sem.group10.CountryCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class CountryPop extends CountryCommandHandler{

    @Override
    public String getCommand() {
        return "population5";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT country.Name as name, country.Population FROM country WHERE country.Name = ? ");
        statement.setString(1, args.get("country"));
        return statement;
    }
}
