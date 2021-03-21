import com.napier.sem.group10.App;
import com.napier.sem.group10.ICommandHandler;
import com.napier.sem.group10.filters.country.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CountriesTesting {

    private static Connection _connection;

    private static CountriesInContinent CountryCont;
    private static CountriesInRegion CountryReg;
    private static CountriesInWorld CountryWorld;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = new App();
        _connection = app.GetSqlConnection();

        CountryCont = new CountriesInContinent();
        CountryReg = new CountriesInRegion();
        CountryWorld = new CountriesInWorld();

    }

    /**
     * Executes a query on the command handler with provided args and asserts the expected rows match.
     * @param handler The command handler
     * @param args Args to execute the command with
     * @param expectedRows An array of CSV lines that are expected
     */


    @Test
    public void CountriesInContinentCommandValid()
    {
        assertNotNull(CountryCont.getCommand());
        assertTrue(CountryWorld.getCommand().startsWith("country"));
    }

    @Test
    public void CountriesInRegionCommandValid()
    {
        assertNotNull(CountryReg.getCommand());
        assertTrue(CountryReg.getCommand().startsWith("country"));
    }

    @Test
    public void CountriesInWorldCommandValid()
    {
        assertNotNull(CountryWorld.getCommand());
        assertTrue(CountryWorld.getCommand().startsWith("country"));
    }


}
