package group10;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class LanguageCommandHandler implements ICommandHandler {
    /**
     * The organisation has asked if it is possible to provide the number of people who speak
     * the following the following languages from greatest number to smallest, including the
     * percentage of the world population
     * @param set The SQL result set
     * @return Relevant columns
     */
    @Override
    public String getResultRow(ResultSet set) throws SQLException {
        String name = set.getString("Name");
        long population = set.getLong("Population");
        String percent = set.getString("Percent");
        return String.format("\"%s\",%s,\"%s\"", name, population, percent);
    }
}
