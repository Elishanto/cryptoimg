package ru.elishanto.cryptoimg;

import ru.elishanto.cryptoimg.exception.InvalidSizeException;
import ru.elishanto.cryptoimg.util.CryptoImgUtils;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InvalidSizeException {
        CryptoImgUtils utils = new CryptoImgUtils();
        long took;
        switch (args[0]) {
            case "-c":
                switch (args[1]) {
                    case "-f":
                        took = utils.crypto(new File(args[2]), new File(args[3]));
                        System.out.println((double) took / 1000 + " seconds");
                        break;
                    default:
                        took = utils.crypto(args[1], new File(args[2]));
                        System.out.println((double) took / 1000 + " seconds");
                        break;
                }
                break;
            case "-d":
                took = utils.decrypto(new File(args[1]), new File(args[2]));
                System.out.println((double) took / 1000 + " seconds");
                break;
        }
    }
}