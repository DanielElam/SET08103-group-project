package group10.filters.city;

import group10.CityCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * All the cities in a region organised by largest population to smallest.
 */
public class CitiesInRegion extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city3";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT city.Name as Name, country.Name as Country, city.District, city.Population FROM city JOIN country ON city.CountryCode=country.Code WHERE city.CountryCode IN(SELECT Code FROM country WHERE country.Region = ?)ORDER BY population DESC LIMIT ?");
        statement.setString(1, args.get("region"));
        int limit = Integer.parseInt(args.getOrDefault("limit", "9999999"));
        statement.setInt(2, limit);
        return statement;
    }
}
