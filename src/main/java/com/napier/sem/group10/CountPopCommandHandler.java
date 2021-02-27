package com.napier.sem.group10;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CountPopCommandHandler implements ICommandHandler {

    /**
     * For the counting of population reports, the following information is requested:
     *  The name of the continent/country/region/district.
     *  The total population of the continent/country/region/district..
     * @param set The SQL result set
     * @return Relevant columns
     */

    @Override
    public String getResultRow(ResultSet set) throws SQLException {
        String name = set.getString("Name");
        long population = set.getLong("Population");
        return String.format("\"%s\",%s,\"N/A\",\"N/A\"", name, population);
    }
}
