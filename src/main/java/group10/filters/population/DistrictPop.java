package group10.filters.population;

import group10.CountPopCommandHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DistrictPop extends CountPopCommandHandler{

    @Override
    public String getCommand() {
        return "population5";
    }

    @Override
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT city.District AS name, SUM(population) AS population FROM city WHERE District = ?");
        statement.setString(1, args.get("district"));
        return statement;
    }
}
