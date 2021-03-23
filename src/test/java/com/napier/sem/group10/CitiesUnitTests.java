package com.napier.sem.group10;

import group10.filters.city.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CitiesUnitTests
{
    private static CitiesInContinent CityCont;
    private static CitiesInCountry CityCountry;
    private static CitiesInDistrict CityDist;
    private static CitiesInRegion CityReg;
    private static CitiesInWorld CityWorld;

    @BeforeAll
    public static void Init() {
        CityCont = new CitiesInContinent();
        CityCountry = new CitiesInCountry();
        CityDist = new CitiesInDistrict();
        CityReg = new CitiesInRegion();
        CityWorld = new CitiesInWorld();
    }

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
}