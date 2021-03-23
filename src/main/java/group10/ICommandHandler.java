package group10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface ICommandHandler {
    /**
     * Returns the SQL statement that will give the required results.
     * @param args Any user-provided parameters.
     * @return An SQL statement string
     */
    public PreparedStatement prepareStatement(Connection connection, Map<String, String> args) throws SQLException;

    /**
     * Returns the result as a CSV row line.
     * @param set The SQL result set
     * @return CSV line
     */
    public String getResultRow(ResultSet set) throws SQLException;

    String getCommand();
}
