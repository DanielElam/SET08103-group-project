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
    private static Helper _helper;

    private static CitiesInContinent CityCont;
    private static CitiesInCountry CityCountry;
    private static CitiesInDistrict CityDist;
    private static CitiesInRegion CityReg;
    private static CitiesInWorld CityWorld;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = new App();
        _helper = new Helper(app.GetSqlConnection());

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

    /*
        Query tests
        Ensure the queries return expected results.
     */

    @Test
    public void CitiesInWorldQueryCorrect() {
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
        _helper.AssertQuery(CityCountry, args, rows);
    }

    @Test
    public void CitiesInContinentQueryCorrect() {
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
        _helper.AssertQuery(CityCountry, args, rows);
    }

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
        _helper.AssertQuery(CityCountry, args, rows);
    }

    /* -------------------------------------------------------------------------------- */
}