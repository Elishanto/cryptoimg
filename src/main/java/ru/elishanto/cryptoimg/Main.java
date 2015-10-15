package ru.elishanto.cryptoimg;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import static ru.elishanto.cryptoimg.Crypter.*;

public class Main {
    public static void main(String[] args) throws IOException {
        switch (args[0]) {
            case "-c":
                switch (args[1]) {
                    case "-f":
                        long before = System.currentTimeMillis();
                        StringBuilder stringBuilder = new StringBuilder();
                        BufferedReader reader = new BufferedReader(new FileReader(args[2]));
                        while (reader.ready()) {
                            String to = reader.readLine();
                            stringBuilder.append(to).append("\n");
                        }
                        reader.close();
                        ImageIO.write(encrypt(stringBuilder.toString()), "png", new File(args[3] + ".cti"));
                        long after = System.currentTimeMillis();
                        System.out.println((double) (after - before) / 1000 + " seconds");
                        break;
                    default:
                        ImageIO.write(encrypt(args[2]), "png", new File(args[3] + ".cti"));
                        break;
                }
                break;
            case "-d":
                long before = System.currentTimeMillis();
                BufferedImage image = ImageIO.read(new File(args[1]));
                String result = decrypt(image);
                PrintWriter printWriter = new PrintWriter(new File(args[2]));
                printWriter.println(result);
                printWriter.close();
                long after = System.currentTimeMillis();
                System.out.println((double) (after - before) / 1000 + " seconds");
                break;
        }
    }
}