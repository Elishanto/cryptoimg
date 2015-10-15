package ru.elishanto.cryptoimg;

import java.util.ArrayList;

import static ru.elishanto.cryptoimg.util.ArrayUtils.getLength;

public class Coder {
    public static String decode(ArrayList<String> arrayList) {
        StringBuilder result = new StringBuilder();
        String to = arrayList.get(arrayList.size() - 1);
        to = to.substring(0, to.length()-1);
        arrayList.set(arrayList.size()-1, to);
        for (String string : arrayList) {
            int charCode = Integer.parseInt(string, 2);
            result.append(Character.toString((char) charCode));
        }
        return result.toString();
    }

    public static ArrayList<String> encode(String text) {
        byte[] bytes = text.replaceAll("[а-яА-Я]","*").getBytes();
        ArrayList<String> result = new ArrayList<>();
        for (byte b : bytes)
        {
            int val = b;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < 8; i++)
            {
                Integer to = (val & 128) == 0 ? 0 : 1;
                res.append(to);
                val <<= 1;
            }
            result.add(res.toString().substring(1));
        }

        if(getLength(result) % 2 != 0)
            result.set(result.size()-1, result.get(result.size()-1) + "0");
        return result;
    }
}