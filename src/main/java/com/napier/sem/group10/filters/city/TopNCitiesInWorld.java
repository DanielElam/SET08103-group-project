package com.napier.sem.group10.filters.city;

import com.napier.sem.group10.CityCommandHandler;

/**
 * The top N populated cities in the world where N is provided by the user.
 */
public class TopNCitiesInWorld extends CityCommandHandler {
    @Override
    public String getCommand() {
        return "city6-n";
    }

    @Override
    public String getSqlStatement(String[] args) {
        return ""; // TODO
    }
}



