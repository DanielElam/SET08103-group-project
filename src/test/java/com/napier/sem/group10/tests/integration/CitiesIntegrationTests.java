package com.napier.sem.group10.tests.integration;

import com.napier.sem.group10.Helper;
import group10.*;
import group10.filters.city.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

class CitiesIntegrationTests
{
    private static Helper _helper;

    private static CitiesInContinent CityCont;
    private static CitiesInCountry CityCountry;
    private static CitiesInDistrict CityDist;
    private static CitiesInRegion CityReg;
    private static CitiesInWorld CityWorld;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = App.GetInstance();
        _helper = new Helper(app.GetSqlConnection());

        CityCont = new CitiesInContinent();
        CityCountry = new CitiesInCountry();
        CityDist = new CitiesInDistrict();
        CityReg = new CitiesInRegion();
        CityWorld = new CitiesInWorld();
    }

    @Test
    public void CitiesInWorldQueryCorrect() {
        var args = new HashMap<String, String>();
        var rows = new String[]{
                "\"Mumbai (Bombay)\",\"India\",\"Maharashtra\",10500000",
                "\"Seoul\",\"South Korea\",\"Seoul\",9981619",
                "\"São Paulo\",\"Brazil\",\"São Paulo\",9968485",
                "\"Shanghai\",\"China\",\"Shanghai\",9696300",
                "\"Jakarta\",\"Indonesia\",\"Jakarta Raya\",9604900",
                "\"Karachi\",\"Pakistan\",\"Sindh\",9269265",
                "\"Istanbul\",\"Turkey\",\"Istanbul\",8787958",
                "\"Ciudad de México\",\"Mexico\",\"Distrito Federal\",8591309",
                "\"Moscow\",\"Russian Federation\",\"Moscow (City)\",8389200",
                "\"New York\",\"United States\",\"New York\",8008278",
                "\"Tokyo\",\"Japan\",\"Tokyo-to\",7980230",
                "\"Peking\",\"China\",\"Peking\",7472000",
                "\"London\",\"United Kingdom\",\"England\",7285000",
                "\"Delhi\",\"India\",\"Delhi\",7206704",
                "\"Cairo\",\"Egypt\",\"Kairo\",6789479"
        };
        _helper.AssertQuery(CityWorld, args, rows);
    }

    @Test
    public void CitiesInContinentQueryCorrect() {
        var args = new HashMap<String, String>();
        args.put("continent", "Europe");
        var rows = new String[]{
                "\"Moscow\",\"Russian Federation\",\"Moscow (City)\",8389200",
                "\"London\",\"United Kingdom\",\"England\",7285000",
                "\"St Petersburg\",\"Russian Federation\",\"Pietari\",4694000",
                "\"Berlin\",\"Germany\",\"Berliini\",3386667",
                "\"Madrid\",\"Spain\",\"Madrid\",2879052",
                "\"Roma\",\"Italy\",\"Latium\",2643581",
                "\"Kyiv\",\"Ukraine\",\"Kiova\",2624000",
                "\"Paris\",\"France\",\"Île-de-France\",2125246",
                "\"Bucuresti\",\"Romania\",\"Bukarest\",2016131",
                "\"Budapest\",\"Hungary\",\"Budapest\",1811552",
                "\"Hamburg\",\"Germany\",\"Hamburg\",1704735",
                "\"Minsk\",\"Belarus\",\"Horad Minsk\",1674000",
                "\"Warszawa\",\"Poland\",\"Mazowieckie\",1615369",
                "\"Wien\",\"Austria\",\"Wien\",1608144",
                "\"Barcelona\",\"Spain\",\"Katalonia\",1503451"
        };
        _helper.AssertQuery(CityCont, args, rows);
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
}