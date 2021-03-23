package group10.filters.population;

import group10.CountPopCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class ContinentPop extends CountPopCommandHandler{

    @Override
    public String getCommand() {
        return "population8";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT country.Continent as name, SUM(population) AS population FROM country WHERE Continent = ?");
        statement.setString(1, args.get("continent"));
        return statement;
    }
}