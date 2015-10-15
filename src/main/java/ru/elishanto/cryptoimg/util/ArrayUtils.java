package ru.elishanto.cryptoimg.util;

import java.util.ArrayList;

public class ArrayUtils {
    public static int getLength(ArrayList<String> arrayList) {
        int length = 0;
        for (String string : arrayList) {
            length += String.valueOf(string).length();
        }
        return length;
    }

    public static String getString(ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        arrayList.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}