package com.proffesionals.ovapp;
import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    private static ResourceBundle text;
    public static Locale currentLanguage = Locale.of("nl");

    public static void setLocale(Locale language) {
        //Load ResourceBundle on provided language
        text = ResourceBundle.getBundle("text", language);
        currentLanguage = language;
    }

    //Get text from ResourceBundle
    public static String getText(String key) {
        return text.getString(key);
    }

    public static void setLanguage(Locale language) {
        setLocale(language);
    }
    public static Locale getCurrentLanguage() {
        return currentLanguage;
    }
    public static void setCurrentLanguage(Locale language) {
        currentLanguage = language;
    }
}

