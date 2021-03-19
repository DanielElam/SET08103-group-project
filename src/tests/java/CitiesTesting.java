import com.napier.sem.group10.filters.city.*;

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
     void CityContStartsWith()
    {
        assertNotNull(CityCont.getCommand());
        assertTrue(CityCont.getCommand().startsWith("city"));
    }

    @Test
    void CityCountryStartsWith()
    {
        assertNotNull(CityCountry.getCommand());
        assertTrue(CityCountry.getCommand().startsWith("city"));

    }
    @Test
    void CityDistStartsWith()
    {
        assertNotNull(CityDist.getCommand());
        assertTrue(CityDist.getCommand().startsWith("city"));
    }
    @Test
    void CityRegStartsWith()
    {
        assertNotNull(CityCountry.getCommand());
        assertTrue(CityReg.getCommand().startsWith("city"));
    }
    @Test
    void CityWorldStartsWith()
    {
        assertNotNull(CityWorld.getCommand());
        assertTrue(CityWorld.getCommand().startsWith("city"));
    }




}