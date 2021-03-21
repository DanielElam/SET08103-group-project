import com.napier.sem.group10.ICommandHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public final class Helper {

    private final Connection _connection;

    public Helper(Connection connection) {
        _connection = connection;
    }

    /**
     * Executes a query on the command handler with provided args and asserts the expected rows match.
     * @param handler The command handler
     * @param args Args to execute the command with
     * @param expectedRows An array of CSV lines that are expected
     */
    public void AssertQuery(ICommandHandler handler, Map<String, String> args, String[] expectedRows) {
        try {
            var statement = handler.prepareStatement(_connection, args);
            ResultSet set = statement.executeQuery();
            int i = 0;
            while (set.next()) {
                String line = handler.getResultRow(set);
                assertEquals(line, expectedRows[i]);
                i++;
                if (i == expectedRows.length)
                    break;
            }
            if (i < expectedRows.length)
                fail("Expected more rows.");
        }
        catch (SQLException e) {
            fail(e);
        }
    }
}
