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
import java.util.HashMap;
import java.util.Map;

public class CountriesTesting {

    private static Helper _helper;

    private static CountriesInContinent CountryCont;
    private static CountriesInRegion CountryReg;
    private static CountriesInWorld CountryWorld;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = new App();
        _helper = new Helper(app.GetSqlConnection());

        CountryCont = new CountriesInContinent();
        CountryReg = new CountriesInRegion();
        CountryWorld = new CountriesInWorld();

    }

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

    @Test
    public void CountriesInContinentQueryCorrect() {
        var args = new HashMap<String, String>();
        args.put("continent", "Asia");
        var rows = new String[]{
                "\"CHN\",\"China\",\"Asia\",\"Eastern Asia\",1277558000,Peking",
                "\"IND\",\"India\",\"Asia\",\"Southern and Central Asia\",1013662000,New Delhi",
                "\"IDN\",\"Indonesia\",\"Asia\",\"Southeast Asia\",212107000,Jakarta",
                "\"PAK\",\"Pakistan\",\"Asia\",\"Southern and Central Asia\",156483000,Islamabad",
                "\"BGD\",\"Bangladesh\",\"Asia\",\"Southern and Central Asia\",129155000,Dhaka",
                "\"JPN\",\"Japan\",\"Asia\",\"Eastern Asia\",126714000,Tokyo",
                "\"VNM\",\"Vietnam\",\"Asia\",\"Southeast Asia\",79832000,Hanoi",
                "\"PHL\",\"Philippines\",\"Asia\",\"Southeast Asia\",75967000,Manila",
                "\"IRN\",\"Iran\",\"Asia\",\"Southern and Central Asia\",67702000,Teheran",
                "\"TUR\",\"Turkey\",\"Asia\",\"Middle East\",66591000,Ankara",
                "\"THA\",\"Thailand\",\"Asia\",\"Southeast Asia\",61399000,Bangkok",
                "\"KOR\",\"South Korea\",\"Asia\",\"Eastern Asia\",46844000,Seoul",
                "\"MMR\",\"Myanmar\",\"Asia\",\"Southeast Asia\",45611000,Rangoon (Yangon)",
                "\"UZB\",\"Uzbekistan\",\"Asia\",\"Southern and Central Asia\",24318000,Toskent",
                "\"PRK\",\"North Korea\",\"Asia\",\"Eastern Asia\",24039000,Pyongyang",
        };
        _helper.AssertQuery(CountryCont, args, rows);
    }


}
