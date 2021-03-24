package com.napier.sem.group10.tests.integration;

import com.napier.sem.group10.App;
import com.napier.sem.group10.filters.language.Language;
import com.napier.sem.group10.tests.Helper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class LanguageTests {

    private static Helper _helper;

    private static Language Language;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        App app = App.GetInstance();
        _helper = new Helper(app.GetSqlConnection());
        Language = new Language();
    }

    @Test
    public void LanguageQueryCorrect() {
        var args = new HashMap<String, String>();
        var rows = new String[]{
                "\"Chinese\",119184353900,\"32%\"",
                "\"Hindi\",40563307000,\"17%\"",
                "\"Spanish\",35502946200,\"12%\"",
                "\"English\",34707786730,\"10%\"",
                "\"Arabic\",23383923870,\"9%\""
        };
        _helper.AssertQuery(Language, args, rows);
    }
}
