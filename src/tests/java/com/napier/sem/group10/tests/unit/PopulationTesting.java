package com.napier.sem.group10.tests.unit;

import com.napier.sem.group10.filters.population.PeopleLivingInAndOutOfCitiesInEachContinent;
import com.napier.sem.group10.filters.population.PeopleLivingInAndOutOfCitiesInEachCountry;
import com.napier.sem.group10.filters.population.PeopleLivingInAndOutOfCitiesInEachRegion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PopulationTesting {
    private static PeopleLivingInAndOutOfCitiesInEachContinent LivingInCitiesContinent;
    private static PeopleLivingInAndOutOfCitiesInEachCountry LivingInCitiesCountry;
    private static PeopleLivingInAndOutOfCitiesInEachRegion LivingInCitiesRegion;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        LivingInCitiesContinent = new PeopleLivingInAndOutOfCitiesInEachContinent();
        LivingInCitiesCountry = new PeopleLivingInAndOutOfCitiesInEachCountry();
        LivingInCitiesRegion = new PeopleLivingInAndOutOfCitiesInEachRegion();

    }

    @Test
    public void LivingInCitiesContinentCommandValid() {
        assertNotNull(LivingInCitiesContinent.getCommand());
        assertTrue(LivingInCitiesContinent.getCommand().startsWith("population"));
    }

    @Test
    public void LivingInCitiesCountryCommandValid() {
        assertNotNull(LivingInCitiesCountry.getCommand());
        assertTrue(LivingInCitiesCountry.getCommand().startsWith("population"));
    }

    @Test
    public void LivingInCitiesRegionCommandValid() {
        assertNotNull(LivingInCitiesRegion.getCommand());
        assertTrue(LivingInCitiesRegion.getCommand().startsWith("population"));
    }
}
