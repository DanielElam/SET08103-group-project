package com.napier.sem.group10.tests.integration;

import com.napier.sem.group10.App;
import com.napier.sem.group10.filters.population.PeopleLivingInAndOutOfCitiesInEachContinent;
import com.napier.sem.group10.filters.population.PeopleLivingInAndOutOfCitiesInEachCountry;
import com.napier.sem.group10.filters.population.PeopleLivingInAndOutOfCitiesInEachRegion;
import com.napier.sem.group10.tests.Helper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PopulationTests {

    private static Helper _helper;

    private static PeopleLivingInAndOutOfCitiesInEachContinent LivingInCitiesContinent;
    private static PeopleLivingInAndOutOfCitiesInEachCountry LivingInCitiesCountry;
    private static PeopleLivingInAndOutOfCitiesInEachRegion LivingInCitiesRegion;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = App.GetInstance();
        _helper = new Helper(app.GetSqlConnection());

        LivingInCitiesContinent = new PeopleLivingInAndOutOfCitiesInEachContinent();
        LivingInCitiesCountry = new PeopleLivingInAndOutOfCitiesInEachCountry();
        LivingInCitiesRegion = new PeopleLivingInAndOutOfCitiesInEachRegion();
    }

    @Test
    public void LivingInCitiesContinentQueryCorrect() {
        var args = new HashMap<String, String>();
        args.put("continent", "Asia");
        var rows = new String[]{
                "\"Asia\",900937599400,697604103,900239995297",
                "\"Europe\",55118944000,241942813,54877001187",
                "\"North America\",95330838000,168250381,95162587619",
                "\"Africa\",16179610000,135838579,16043771421",
                "\"Oceania\",307500750,13886149,293614601",
                "\"South America\",48533025000,172037859,48360987141"
        };
        _helper.AssertQuery(LivingInCitiesContinent, args, rows);
    }

    @Test
    public void LivingInCitiesCountryQueryCorrect() {
        var args = new HashMap<String, String>();
        var rows = new String[]{
                "\"Afghanistan\",90880000,2332100,88547900",
                "\"Netherlands\",444192000,5180049,439011951",
                "\"Netherlands Antilles\",217000,2345,214655",
                "\"Albania\",3401200,270000,3131200",
                "\"Algeria\",566478000,5192179,561285821",
                "\"American Samoa\",136000,7523,128477",
                "\"Andorra\",78000,21189,56811",
                "\"Angola\",64390000,2561600,61828400",
                "\"Anguilla\",16000,1556,14444",
                "\"Antigua and Barbuda\",68000,24000,44000",
                "\"United Arab Emirates\",12205000,1728336,10476664",
                "\"Argentina\",2110824000,19996563,2090827437",
                "\"Armenia\",10560000,1633100,8926900",
                "\"Aruba\",103000,29034,73966",
        };
        _helper.AssertQuery(LivingInCitiesCountry, args, rows);
    }

    @Test
    public void LivingInCitiesRegionQueryCorrect() {
        var args = new HashMap<String, String>();
        var rows = new String[]{
                "\"Southern and Central Asia\",363665421000,207688970,363457732030",
                "\"Western Europe\",10631609200,45683298,10585925902",
                "\"Caribbean\",288771000,11067550,277703450",
                "\"Southern Europe\",5932101100,40016658,5892084442",
                "\"Northern Africa\",4176871000,43449514,4133421486",
                "\"Polynesia\",936050,135925,800125",
                "\"Central Africa\",1126386000,19061775,1107324225",
                "\"Middle East\",5517497400,70371374,5447126026",
                "\"South America\",48533025000,172037859,48360987141",
                "\"Australia and New Zealand\",299167700,13163436,286004264",
                "\"Central America\",17245853000,65860964,17179992036",
                "\"Western Africa\",7529990000,33222032,7496767968",
                "\"North America\",77796214000,91321867,77704892133",
                "\"Southern Africa\",1784719000,16038192,1768680808",
                "\"British Islands\",4837045600,23045714,4813999886",
                "\"Southeast Asia\",32033017000,102067225,31930949775",
                "\"Eastern Europe\",33471056800,123384516,33347672284",
                "\"Eastern Africa\",1561644000,24067066,1537576934",
                "\"Melanesia\",6472000,484459,5987541",
                "\"Nordic Countries\",218487800,6865487,211622313",
                "\"Micronesia\",925000,102329,822671",
                "\"Eastern Asia\",499721664000,317476534,499404187466",
                "\"Baltic Countries\",28643500,2947140,25696360",
        };
        _helper.AssertQuery(LivingInCitiesRegion, args, rows);
    }


}
