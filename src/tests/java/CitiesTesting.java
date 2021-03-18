import com.napier.sem.group10.filters.city.*;
import fi.iki.elonen.NanoHTTPD;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class CitiesTesting
{

    static CitiesInContinent CityCont;
    static CitiesInCountry CityCountry;
    static CitiesInDistrict CityDist;
    static CitiesInRegion CityReg;
    static CitiesInWorld CityWorld;

    @BeforeAll
    static void init()
    {
        CityCont = new CitiesInContinent();
        CityCountry = new CitiesInCountry();
        CityDist = new CitiesInDistrict();
        CityReg = new CitiesInRegion();
        CityWorld = new CitiesInWorld();

    }

    @Test
    void testTest()
    {
        assertEquals(5,5);
    }

    @Test
     void CityContNotNull()
    {
        assertNotNull(CityCont.getCommand());
    }
    @Test
    void CityCountryNotNull()
    {
        assertNotNull(CityCountry.getCommand());
    }
    @Test
    void CityDistNotNull()
    {
        assertNotNull(CityDist.getCommand());
    }
    @Test
    void CityRegNotNull()
    {
        assertNotNull(CityCountry.getCommand());
    }
    @Test
    void CityWorldNotNull()
    {
        assertNotNull(CityWorld.getCommand());
    }




}