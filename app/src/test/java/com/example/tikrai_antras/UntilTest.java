package com.example.tikrai_antras;

import org.junit.Test;
import static org.junit.Assert.*;
public class UntilTest {

    @Test
    public void countWords_tusciaIvestis_grazinaNuli() {
        // neįvedamas joks tekstas ("")
        assertEquals(0, Until.countWords(""));
    }

    @Test
    public void countWords_nullIvestis_grazinaNuli() {
        //NULL reikšmė
        assertEquals(0, Until.countWords(null));
    }

    @Test
    public void countWords_normalusTekstas_grazinaTeisingaSkaiciu() {
        //normalus tekstas
        String text = "Šiame tekste yra penki žodžiai.";
        assertEquals(5, Until.countWords(text));
    }

    @Test
    public void countWords_daugybeTarpai_grazinaTeisingaSkaiciu() {
        //keli tarpai tarp žodžių
        String text = "vienas    du   trys";
        assertEquals(3, Until.countWords(text));
    }

    @Test
    public void countWords_tarpaiPradziojePabaigoje_grazinaTeisingaSkaiciu() {
        //tarpai pradžioje ir pabaigoje
        String text = "  labas pasauli  ";
        assertEquals(2, Until.countWords(text));
    }

    @Test
    public void countWords_tikTarpai_grazinaNuli() {
        //įvesti tik tarpai
        String text = "     ";
        assertEquals(0, Until.countWords(text));
    }

    @Test
    public void countWords_tikSkyryba_grazinaViena() {
        //įvesti tik skyrybos ženklai traktuojami kaip vienas žodis)
        String text = ".,?!";
        assertEquals(1, Until.countWords(text));
    }

    @Test
    public void countCharacters_tusciaIvestis_grazinaNuli() {
        assertEquals(0, Until.countCharacters(""));
    }

    @Test
    public void countCharacters_nullIvestis_grazinaNuli() {
        assertEquals(0, Until.countCharacters(null));
    }

    @Test
    public void countCharacters_normalusTekstas_grazinaTeisingaSkaiciu() {
        String text = "Sveikinu, tai yra testas!";
        assertEquals(25, Until.countCharacters(text));
    }

    @Test
    public void countCharacters_tikTarpai_grazinaTinkamaSkaiciu() {
        String text = "   ";
        assertEquals(3, Until.countCharacters(text));
    }

    @Test
    public void countCharacters_suSkyryba_grazinaTinkamaSkaiciu() {
        String text = "!@#$%^&";
        assertEquals(7, Until.countCharacters(text));
    }
}