package com.proffesionals.ovapp;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    private static ResourceBundle text = ResourceBundle.getBundle("text", Locale.of("nl"));    

    //Get text from ResourceBundle
    public static String getText(String key) {
        return text.getString(key);
    }

    public static void setLanguage(Locale language) {
        text = ResourceBundle.getBundle("text", language);
    }
}

