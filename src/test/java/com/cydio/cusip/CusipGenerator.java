package com.cydio.cusip;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CusipGenerator {

    private static final String DEFAULT_FILE = "cusip.txt";
    private static final int CUSIP_TOTAL_COUNT = 1000;

    public static void main(String[] args) throws Exception {

        File file = new File(DEFAULT_FILE);
        file.delete();
        file.createNewFile();

        try (PrintWriter output = new PrintWriter(file)) {
            IntStream.range(0, CUSIP_TOTAL_COUNT).forEach(i -> {

                StringBuilder sb = new StringBuilder();
                sb.append(generateCusipName());
                sb.append(System.lineSeparator());

                String prices = generatePrices().stream().map(price -> String.format("%.2f", price))
                        .collect(joining(System.lineSeparator()));

                sb.append(prices);

                output.println(sb.toString());
            });

            System.out.println("File " + file.getAbsolutePath() + " was generated.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static String generateCusipName() {
        return RandomStringUtils.randomAlphanumeric(8).toUpperCase();
    }

    private static List<Double> generatePrices() {
        int priceCount = ThreadLocalRandom.current().nextInt(1, 10);

        return IntStream.range(0, priceCount)
                .mapToDouble(d -> ThreadLocalRandom.current().nextDouble(1, 10000))
                .boxed()
                .collect(toList());

    }
}
