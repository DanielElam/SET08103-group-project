package group10;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CountryCommandHandler implements ICommandHandler {
    /**
     * A country report requires the following columns:
     *         Code.
     *         Name.
     *         Continent.
     *         Region.
     *         Population.
     *         Capital.
     * @param set The SQL result set
     * @return Relevant columns
     */
    @Override
    public String getResultRow(ResultSet set) throws SQLException {
        String code = set.getString("Code");
        String name = set.getString("Name");
        String continent = set.getString("Continent");
        String region = set.getString("Region");
        long population = set.getLong("Population");
        String capital = set.getString("Capital");
        return String.format("\"%s\",\"%s\",\"%s\",\"%s\",%s,%s", code, name, continent, region, population, capital);
    }
}
