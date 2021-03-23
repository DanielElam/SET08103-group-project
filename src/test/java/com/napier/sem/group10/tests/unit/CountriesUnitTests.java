package com.napier.sem.group10.tests.unit;

import group10.filters.country.CountriesInContinent;
import group10.filters.country.CountriesInRegion;
import group10.filters.country.CountriesInWorld;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountriesUnitTests {

    private static CountriesInContinent CountryCont;
    private static CountriesInRegion CountryReg;
    private static CountriesInWorld CountryWorld;

    @BeforeAll
    public static void Init() {
        CountryCont = new CountriesInContinent();
        CountryReg = new CountriesInRegion();
        CountryWorld = new CountriesInWorld();

    }

    @Test
    public void CountriesInContinentCommandValid() {
        assertNotNull(CountryCont.getCommand());
        assertTrue(CountryWorld.getCommand().startsWith("country"));
    }

    @Test
    public void CountriesInRegionCommandValid() {
        assertNotNull(CountryReg.getCommand());
        assertTrue(CountryReg.getCommand().startsWith("country"));
    }

    @Test
    public void CountriesInWorldCommandValid() {
        assertNotNull(CountryWorld.getCommand());
        assertTrue(CountryWorld.getCommand().startsWith("country"));
    }
}
