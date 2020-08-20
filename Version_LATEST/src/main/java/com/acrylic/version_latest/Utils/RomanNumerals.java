package com.acrylic.version_latest.Utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ref: https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
 *
 * This is a roman numeral converter. I did not make this code!
 * This is a modified version of the roman numeral converter found in Ref.
 */
@UtilityClass
public class RomanNumerals {

    private final TreeMap<Integer, String> mapToRoman = new TreeMap<>();
    private final HashMap<String, Integer> mapToNumber = new HashMap<>();

    static {

        mapToRoman.put(1000, "M");
        mapToRoman.put(900, "CM");
        mapToRoman.put(500, "D");
        mapToRoman.put(400, "CD");
        mapToRoman.put(100, "C");
        mapToRoman.put(90, "XC");
        mapToRoman.put(50, "L");
        mapToRoman.put(40, "XL");
        mapToRoman.put(10, "X");
        mapToRoman.put(9, "IX");
        mapToRoman.put(5, "V");
        mapToRoman.put(4, "IV");
        mapToRoman.put(1, "I");

        mapToRoman.forEach((i, s) -> {
            mapToNumber.put(s,i);
        });

    }

    public String toRoman(int number) {
        int l = mapToRoman.floorKey(number);
        return (number == l) ? mapToRoman.get(number) : mapToRoman.get(l) + toRoman(number-l);
    }

    /**
     * I do not recommend using this method excessively as this
     * method is fairly costly.
     *
     * If the string contains non identifiable roman numeral values,
     * the value will be voided.
     *
     * @param romanNumeral Roman numeral string
     * @return The number conversion.
     public int toIntFromRoman(String romanNumeral) {
        final String[] chars = romanNumeral.split("");
        final int size = chars.length;

        AtomicInteger i = new AtomicInteger(0);
        int output = 0;
        while (i.get() < size) {
            String comp = chars[i.get()];
            mapToNumber.forEach((s, amt) -> {
                int sS = s.length();
                if (sS > 0 && i.get() + sS < size) {

                }
            });
        }
        return output;
    }
     */

}
