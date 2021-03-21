import com.napier.sem.group10.App;
import com.napier.sem.group10.ICommandHandler;
import com.napier.sem.group10.filters.capitalcity.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CapitalCityTests {

    private static Connection _connection;

    private static CapitalCitiesInContinent CapCont;
    private static CapitalCitiesInRegion CapReg;
    private static CapitalCitiesInWorld CapWorld;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = new App();
        _connection = app.GetSqlConnection();

        CapCont = new CapitalCitiesInContinent();
        CapReg = new CapitalCitiesInRegion();
        CapWorld = new CapitalCitiesInWorld();
    }

    /**
     * Executes a query on the command handler with provided args and asserts the expected rows match.
     * @param handler The command handler
     * @param args Args to execute the command with
     * @param expectedRows An array of CSV lines that are expected
     */
    private void AssertQuery(ICommandHandler handler, Map<String, String> args, String[] expectedRows) {
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

    @Test
    public void CapitalCitiesInContinentCommandValid()
    {
        assertNotNull(CapCont.getCommand());
        assertTrue(CapCont.getCommand().startsWith("capitalcity"));
    }

    @Test
    public void CapitalCitiesInRegionCommandValid()
    {
        assertNotNull(CapReg.getCommand());
        assertTrue(CapReg.getCommand().startsWith("capitalcity"));
    }

    @Test
    public void CapitalCitiesInWorldCommandValid()
    {
        assertNotNull(CapWorld.getCommand());
        assertTrue(CapWorld.getCommand().startsWith("capitalcity"));
    }

    @Test
    public void CapitalCitiesInContinentQueryCorrect() {
        var args = new HashMap<String, String>();
        args.put("continent", "Europe");
        var rows = new String[]{
                "\"Moscow\",\"Russian Federation\",8389200",
                "\"London\",\"United Kingdom\",7285000",
                "\"Berlin\",\"Germany\",3386667",
                "\"Madrid\",\"Spain\",2879052",
                "\"Roma\",\"Italy\",2643581",
                "\"Kyiv\",\"Ukraine\",2624000"
        };
        AssertQuery(CapCont, args, rows);
    }



}
