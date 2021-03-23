package group10;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CapitalCityCommandHandler implements ICommandHandler {
    /**
     * A capital city report requires the following columns:
     *  Name.
     *  Country.
     *  Population.
     * @param set The SQL result set
     * @return Relevant columns
     */
    @Override
    public String getResultRow(ResultSet set) throws SQLException {
        String name = set.getString("Name");
        String country = set.getString("Country");
        long population = set.getLong("Population");
        return String.format("\"%s\",\"%s\",%s", name, country, population);
    }
}
