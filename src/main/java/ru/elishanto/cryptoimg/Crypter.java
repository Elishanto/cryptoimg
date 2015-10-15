package ru.elishanto.cryptoimg;

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import static ru.elishanto.cryptoimg.Coder.*;
import static ru.elishanto.cryptoimg.util.ArrayUtils.*;


public class Crypter {
    public static BufferedImage encrypt(String text) {
        ArrayList<String> encoded = encode(text);
        for (int i = 0; i < encoded.size(); i++) {
            while (encoded.get(i).length() < 8)
                encoded.set(i, "0" + String.valueOf(encoded.get(i)));
        }
        BufferedImage image = new BufferedImage(
                getLength(encoded),
                1,
                BufferedImage.TYPE_INT_RGB);
        String[] data = getString(encoded).split("");
            for (int i = 0; i < image.getWidth(); i++) {
                int rgb;
                if (data[i].equals("0")) rgb = -1;
                else rgb = -2;
                image.setRGB(i, 0, rgb);
            }
        return image;
    }

    public static String decrypt(BufferedImage image) throws UnsupportedEncodingException {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < image.getWidth(); i++) {
            if(image.getRGB(i, 0) == -1)
                data.append(0);
            else
                data.append(1);
        }
        String result = decode(new ArrayList<>(
                Arrays.asList(data.toString().split("(?<=\\G........)"))));
        return result.substring(3, result.length()-1);
    }
}