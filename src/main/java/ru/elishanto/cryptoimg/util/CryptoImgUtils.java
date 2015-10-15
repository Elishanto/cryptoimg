package ru.elishanto.cryptoimg.util;

import ru.elishanto.cryptoimg.exception.InvalidSizeException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import static ru.elishanto.cryptoimg.Crypter.decrypt;
import static ru.elishanto.cryptoimg.Crypter.encrypt;

public class CryptoImgUtils {

    public long crypto(File input, File output) throws IOException, InvalidSizeException {
        long before = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(input));
        while (reader.ready()) {
            String to = reader.readLine();
            stringBuilder.append(to).append("\n");
        }
        reader.close();
        ImageIO.write(encrypt(stringBuilder.toString()), "png", new File(output + ".cti"));
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long crypto(String input, File output) throws IOException, InvalidSizeException {
        long before = System.currentTimeMillis();
        ImageIO.write(encrypt(input), "png", new File(output + ".cti"));
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long decrypto(File input, File output) throws IOException {
        long before = System.currentTimeMillis();
        BufferedImage image = ImageIO.read(input);
        String result = decrypt(image);
        PrintWriter printWriter = new PrintWriter(output);
        printWriter.println(result);
        printWriter.close();
        long after = System.currentTimeMillis();
        return after - before;
    }

    public enum Extension {
        FAST, SLOW
    }
}