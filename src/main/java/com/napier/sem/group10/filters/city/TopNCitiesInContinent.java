package com.napier.sem.group10.filters.city;

import com.napier.sem.group10.CityCommandHandler;

/**
 * The top N populated cities in a continent where N is provided by the user.
 */
public class TopNCitiesInContinent extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city7-n";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}
