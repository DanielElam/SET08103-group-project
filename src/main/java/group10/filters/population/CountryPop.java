package group10.filters.population;

import group10.CountPopCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class CountryPop extends CountPopCommandHandler{

    @Override
    public String getCommand() {
        return "population6";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT country.Name as name, country.Population as Population FROM country WHERE country.Name = ? ");
        statement.setString(1, args.get("country"));
        return statement;
    }
}
