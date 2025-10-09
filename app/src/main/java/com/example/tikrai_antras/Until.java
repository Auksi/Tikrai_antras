package com.example.tikrai_antras;

public class Until {
        //skaičiuoja zodzius
        public static int countWords(String text) {
            if (text == null || text.trim().isEmpty()) {
                return 0;
            }
            //skaičiuoja elementus
            String[] words = text.trim().split("\\s+");
            return words.length;
        }

       //skaiciuoja simbolius
        public static int countCharacters(String text) {
            if (text == null) {
                return 0;
            }
            //kaičiuoja visus simbolius eilutėj
            return text.length();
        }
    }
