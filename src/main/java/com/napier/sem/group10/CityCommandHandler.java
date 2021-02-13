package com.napier.sem.group10;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CityCommandHandler implements ICommandHandler {
    /**
     * A city report requires the following columns:
     *  Name.
     *  Country.
     *  District.
     *  Population.
     * @param set The SQL result set
     * @return Relevant columns
     */
    @Override
    public String getResultRow(ResultSet set) throws SQLException {
        String name = set.getString("Name");
        String district = set.getString("District");
        int population = set.getInt("Population");
        return String.format("\"%s\",\"%s\",%d", name, district, population);
    }
}
