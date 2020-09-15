package project.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String getCost(String text) {
        Pattern pattern = Pattern.compile("USD(\\s)(.*)\\s");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println("Found value: " + matcher.group(0));
        }
        return matcher.group(0);
    }
}
