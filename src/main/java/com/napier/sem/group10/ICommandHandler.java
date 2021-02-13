package com.napier.sem.group10;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ICommandHandler {
    /**
     * Returns the SQL statement that will give the required results.
     * @param args Any user-provided parameters.
     * @return An SQL statement string
     */
    public String getSqlStatement(String[] args);

    /**
     * Returns the result as a CSV row line.
     * @param set The SQL result set
     * @return CSV line
     */
    public String getResultRow(ResultSet set) throws SQLException;

    String getCommand();
}
