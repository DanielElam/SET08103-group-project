package com.napier.sem.group10;

import com.napier.sem.group10.filters.*;

import java.sql.*;

public class App {
    private static final String _databaseHost = "localhost:3306";
    private static final String _databaseStore = "world";
    private static final String _databaseUsername = "root";
    private static final String _databasePassword = "therecanbeonlyone";

    private static Connection _connection;

    public static void main(String[] args) {
        var databaseUrl = String.format("jdbc:mysql://%s/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                _databaseHost, _databaseStore);

        try { // Attempt to connect to the database
            _connection = DriverManager.getConnection(
                    databaseUrl,
                    _databaseUsername, _databasePassword);
        } catch (SQLException ex) {
            System.out.println("An error occurred attempting to connect to the database.");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        // TODO: allow user to select, input parameters
        if (_connection != null) {
            executePopulationResult(new CountriesInWorldOrganisedByLargestPopToSmallest(), new String[]{});
        } else {
            System.out.println("Could not connect to database.");
        }
    }

    private static void executePopulationResult(IPopulationResult result, String[] args) {
        try {
            var statement = _connection.createStatement();
            var strSelect = result.getSqlStatement(args);
            System.out.println("Execute SQL statement: " + strSelect + "\n");
            ResultSet rset = statement.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {

                String name = rset.getString("Name");
                String countryCode = rset.getString("Population");
                System.out.println(name + ", " + countryCode);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex) {
            System.out.println("An error occurred attempting to execute: " + result.toString());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}