package src.Locale;

import java.util.ResourceBundle;

/**
 * Created by Artem on 20.11.14.
 */
public class Lockale
{
        public static ResourceBundle BANDLE;
        public static String[] languige = {"en_EN", "ru_RU", "ua_UA"};
        public static Integer LANGUAGE = 0;

        public static ResourceBundle initBundle()
        {
            return BANDLE = ResourceBundle.getBundle(languige[LANGUAGE]);
        }
}
