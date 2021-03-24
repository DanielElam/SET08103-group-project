package com.napier.sem.group10.tests.integration;

import com.napier.sem.group10.App;
import com.napier.sem.group10.filters.country.*;

import com.napier.sem.group10.tests.Helper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class CountriesTests {

    private static Helper _helper;

    private static CountriesInContinent CountryCont;
    private static CountriesInRegion CountryReg;
    private static CountriesInWorld CountryWorld;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = App.GetInstance();
        _helper = new Helper(app.GetSqlConnection());

        CountryCont = new CountriesInContinent();
        CountryReg = new CountriesInRegion();
        CountryWorld = new CountriesInWorld();
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

    @Test
    public void CountriesInWorldQueryCorrect() {
        var args = new HashMap<String, String>();
        var rows = new String[]{
                "\"CHN\",\"China\",\"Asia\",\"Eastern Asia\",1277558000,Peking",
                "\"IND\",\"India\",\"Asia\",\"Southern and Central Asia\",1013662000,New Delhi",
                "\"USA\",\"United States\",\"North America\",\"North America\",278357000,Washington",
                "\"IDN\",\"Indonesia\",\"Asia\",\"Southeast Asia\",212107000,Jakarta",
                "\"BRA\",\"Brazil\",\"South America\",\"South America\",170115000,Brasília",
                "\"PAK\",\"Pakistan\",\"Asia\",\"Southern and Central Asia\",156483000,Islamabad",
                "\"RUS\",\"Russian Federation\",\"Europe\",\"Eastern Europe\",146934000,Moscow",
                "\"BGD\",\"Bangladesh\",\"Asia\",\"Southern and Central Asia\",129155000,Dhaka",
                "\"JPN\",\"Japan\",\"Asia\",\"Eastern Asia\",126714000,Tokyo",

        };
        _helper.AssertQuery(CountryWorld, args, rows);

    }

    @Test
    public void CountriesInRegionQueryCorrect() {
        var args = new HashMap<String, String>();
        args.put("region", "Western Europe");
        var rows = new String[]{
                "\"DEU\",\"Germany\",\"Europe\",\"Western Europe\",82164700,Berlin",
                "\"FRA\",\"France\",\"Europe\",\"Western Europe\",59225700,Paris",
                "\"NLD\",\"Netherlands\",\"Europe\",\"Western Europe\",15864000,Amsterdam",
                "\"BEL\",\"Belgium\",\"Europe\",\"Western Europe\",10239000,Bruxelles [Brussel]",
                "\"AUT\",\"Austria\",\"Europe\",\"Western Europe\",8091800,Wien",
                "\"CHE\",\"Switzerland\",\"Europe\",\"Western Europe\",7160400,Bern",
                "\"LUX\",\"Luxembourg\",\"Europe\",\"Western Europe\",435700,Luxembourg [Luxemburg/Lëtzebuerg]",
        };
        _helper.AssertQuery(CountryReg, args, rows);
    }

}
