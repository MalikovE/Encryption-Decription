package encryptdecrypt;

import encryptdecrypt.algorithms.Encoder;
import encryptdecrypt.algorithms.Shift;
import encryptdecrypt.algorithms.Unicode;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        loadContext(args);

        Encoder encoder = new Encoder();
        if (AppContext.algorithm.equals("unicode")) {
            encoder.setAlgorithm(new Unicode());
        } else {
            encoder.setAlgorithm(new Shift());
        }

        if (AppContext.in != null) {
            try (Scanner fileScanner = new Scanner(AppContext.in)) {
                AppContext.message += fileScanner.nextLine();
            } catch (FileNotFoundException e) {
                System.out.println("Input file not found.");
            }
        }

        if (AppContext.out != null) {
            try (FileWriter writer = new FileWriter(AppContext.out)) {
                String result;
                if (AppContext.operation.equals("enc")) {
                    result = encoder.encode(AppContext.message, AppContext.key);
                } else {
                    result = encoder.decode(AppContext.message, AppContext.key);
                }
                writer.write(result);
            } catch (FileNotFoundException e) {
                System.out.println("Output file not found.");
            } catch (IOException e) {
                System.out.println("Cannot write into file.");
            }
        }
    }

    private static void loadContext(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                AppContext.operation = args[i + 1];
            }
            if (args[i].equals("-key")) {
                AppContext.key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                AppContext.message = args[i + 1];
            }
            if (args[i].equals("-in")) {
                AppContext.in = new File(args[i + 1]);
            }
            if (args[i].equals("-out")) {
                AppContext.out = new File(args[i + 1]);
            }
            if (args[i].equals("-alg")) {
                AppContext.algorithm = args[i + 1];
            }
        }
    }
}

