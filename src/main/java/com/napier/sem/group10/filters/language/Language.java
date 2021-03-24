package com.napier.sem.group10.filters.language;

import com.napier.sem.group10.CountPopCommandHandler;
import com.napier.sem.group10.LanguageCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class Language extends LanguageCommandHandler {

    @Override
    public String getCommand() {
        return "language";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement worldPopStatement = connection.prepareStatement("SELECT SUM(country.Population) AS WorldPopulation FROM country");
        var resultSet = worldPopStatement.executeQuery();
        resultSet.next();
        long worldPop = resultSet.getLong("WorldPopulation");

        PreparedStatement statement = connection.prepareStatement("SELECT Language as Name, SUM(Percentage*country.Population) AS Population, CONCAT(ROUND(SUM(country.Population / ?) * 100), '%') AS Percent FROM countrylanguage JOIN country ON country.Code=CountryCode GROUP BY Language ORDER BY Population DESC LIMIT 5;");
        statement.setLong(1, worldPop);

        return statement;
    }
}