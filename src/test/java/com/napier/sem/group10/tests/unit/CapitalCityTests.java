package com.napier.sem.group10.tests.unit;

import com.napier.sem.group10.filters.capitalcity.CapitalCitiesInContinent;
import com.napier.sem.group10.filters.capitalcity.CapitalCitiesInRegion;
import com.napier.sem.group10.filters.capitalcity.CapitalCitiesInWorld;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CapitalCityTests {

    private static CapitalCitiesInContinent CapCont;
    private static CapitalCitiesInRegion CapReg;
    private static CapitalCitiesInWorld CapWorld;

    @BeforeAll
    public static void Init() {
        CapCont = new CapitalCitiesInContinent();
        CapReg = new CapitalCitiesInRegion();
        CapWorld = new CapitalCitiesInWorld();
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
}
