package ru.elishanto.cryptoimg.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String compress(String source) {
        StringBuilder dest = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i+1 < source.length() && source.charAt(i) == source.charAt(i+1)) {
                runLength++;
                i++;
            }
            dest.append(runLength);
            dest.append(source.charAt(i));
        }
        if(source.length() > dest.toString().length()) {
            System.out.println("COMPRESSED");
            return dest.toString();
        }
        else {
            System.out.println("NON-COMPRESSED");
            return "N111COED" + source;
        }
    }

    public static String decompress(String source) {
        if(!source.startsWith("N111COED")) {
            StringBuilder dest = new StringBuilder();
            Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
            Matcher matcher = pattern.matcher(source);
            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                matcher.find();
                while (number-- != 0) {
                    dest.append(matcher.group());
                }
            }
            return dest.toString();
        } else {
            return source.substring("N111COED".length());
        }
    }
}
