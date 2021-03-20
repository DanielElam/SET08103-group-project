import com.napier.sem.group10.App;
import com.napier.sem.group10.ICommandHandler;
import com.napier.sem.group10.filters.city.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

class CitiesTesting
{
    private static Connection _connection;

    private static CitiesInContinent CityCont;
    private static CitiesInCountry CityCountry;
    private static CitiesInDistrict CityDist;
    private static CitiesInRegion CityReg;
    private static CitiesInWorld CityWorld;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = new App();
        _connection = app.GetSqlConnection();

        CityCont = new CitiesInContinent();
        CityCountry = new CitiesInCountry();
        CityDist = new CitiesInDistrict();
        CityReg = new CitiesInRegion();
        CityWorld = new CitiesInWorld();
    }


    /*
        Command Valid tests
        Ensure the command name returned by getCommand() is the right category name
     */

    @Test
    public void CitiesInWorldCommandValid()
    {
        assertNotNull(CityWorld.getCommand());
        assertTrue(CityWorld.getCommand().startsWith("city"));
    }

    @Test
    public void CitiesInContinentCommandValid()
    {
        assertNotNull(CityCont.getCommand());
        assertTrue(CityCont.getCommand().startsWith("city"));
    }

    @Test
    public void CitiesInRegionCommandValid()
    {
        assertNotNull(CityReg.getCommand());
        assertTrue(CityReg.getCommand().startsWith("city"));
    }

    @Test
    public void CitiesInCountryCommandValid()
    {
        assertNotNull(CityCountry.getCommand());
        assertTrue(CityCountry.getCommand().startsWith("city"));

    }

    @Test
    public void CitiesInDistrictCommandValid()
    {
        assertNotNull(CityDist.getCommand());
        assertTrue(CityDist.getCommand().startsWith("city"));
    }

    /* -------------------------------------------------------------------------------- */

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

    /*
        Query tests
        Ensure the queries return expected results.
     */

    @Test
    public void CitiesInCountryQueryCorrect() {
        var args = new HashMap<String, String>();
        args.put("country", "United Kingdom");
        var rows = new String[]{
            "\"London\",\"United Kingdom\",\"England\",7285000",
            "\"Birmingham\",\"United Kingdom\",\"England\",1013000",
            "\"Glasgow\",\"United Kingdom\",\"Scotland\",619680",
            "\"Liverpool\",\"United Kingdom\",\"England\",461000",
            "\"Edinburgh\",\"United Kingdom\",\"Scotland\",450180",
            "\"Sheffield\",\"United Kingdom\",\"England\",431607",
            "\"Manchester\",\"United Kingdom\",\"England\",430000"
        };
        AssertQuery(CityCountry, args, rows);
    }

    /* -------------------------------------------------------------------------------- */
}