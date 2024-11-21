package com.ruppyrup.numbers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatDecimals {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        DecimalFormat rup = new DecimalFormat("#.##");

        // different locale - GERMAN
        DecimalFormat dfGerman = new DecimalFormat("#,###.##",
                new DecimalFormatSymbols(Locale.GERMAN));

        String input = "1234567890.004";
        double d = Double.parseDouble(input);

        System.out.println(df.format(d));       // 1,234,567,890.12
        System.out.println(rup.format(d));       // 1,234,567,890.12

        System.out.println(dfGerman.format(d)); // 1.234.567.890,12
    }
}
