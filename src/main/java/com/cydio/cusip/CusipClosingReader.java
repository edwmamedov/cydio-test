package com.cydio.cusip;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class CusipClosingReader {

    private static final Pattern CUSIP_NAME = Pattern.compile("[A-Z0-9]{8}");
    private static final Pattern CUSIP_PRICE = Pattern.compile("\\d+\\.\\d{1,2}");

    /**
     *  result maps cusip's name to it's closing price
     */
    public Map<String, BigDecimal> read(File file) throws Exception {
        final Map<String, BigDecimal> result = new HashMap<>();

        try (LineIterator it = FileUtils.lineIterator(file, "UTF-8")) {

            Deque<String> deque = new LinkedList<>();

            while (it.hasNext()) {
                String line = it.nextLine();

                if (CUSIP_NAME.matcher(line).matches()) {
                    if (deque.size() != 0) {

                        CusipClosing cusip = readRec(deque);

                        result.put(cusip.getName(), cusip.getClosingPrice());
                    }

                    deque.clear();
                    deque.push(line);
                }

                if (CUSIP_PRICE.matcher(line).matches()) {
                    deque.push(line);
                }
            }
            // processing last one
            CusipClosing cusip = readRec(deque);
            result.put(cusip.getName(), cusip.getClosingPrice());
        }

        return result;
    }


    private CusipClosing readRec(Deque<String> cusipRec) {
        return new CusipClosing(cusipRec.pollLast(), new BigDecimal(cusipRec.getFirst()));
    }

}
