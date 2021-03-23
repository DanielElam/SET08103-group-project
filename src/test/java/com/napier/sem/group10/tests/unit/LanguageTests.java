package com.napier.sem.group10.tests.unit;

import com.napier.sem.group10.filters.language.Language;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageTests {
    private static Language Language;

    @BeforeAll
    public static void Init() throws IOException, InterruptedException {
        Language = new Language();
    }

    @Test
    public void LanguageCommandValid() {
        assertNotNull(Language.getCommand());
        assertTrue(Language.getCommand().startsWith("language"));
    }
}
