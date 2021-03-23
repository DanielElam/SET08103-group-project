package group10.filters.city;

import group10.CityCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * All the cities in the world organised by largest population to smallest
 */
public class CitiesInWorld extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city1";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT city.Name as Name, country.Name as Country, city.District, city.Population FROM city JOIN country ON city.CountryCode=country.Code ORDER BY population DESC LIMIT ?");
        int limit = Integer.parseInt(args.getOrDefault("limit", "9999999"));
        statement.setInt(1, limit);
        return statement;
    }
}
