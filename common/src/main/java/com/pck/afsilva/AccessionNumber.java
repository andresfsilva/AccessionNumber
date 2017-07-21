package com.pck.afsilva;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Separates the letters and digits of an Accesion Number
 * Provides methods to determine if two Accession Numbers are continous
 * Implements the comparable interface
 *
 * @author afsilva
 */
public class AccessionNumber implements Comparable<AccessionNumber> {

    private static final Pattern PATTERN = Pattern.compile("([A-Z])+(\\d+)");
    private final int digits;
    private final String alphaString;
    private final String original;
    private final int number;

    public AccessionNumber(String string){
        Matcher matcher = PATTERN.matcher(string);
        matcher.matches();

        this.alphaString = matcher.group(1);
        String number = matcher.group(2);
        this.digits = number.length();
        this.number = Integer.valueOf(number);
        this.original = string;
    }

    @Override
    public int compareTo(AccessionNumber o) {
        return original.compareTo(o.original);
    }

    public boolean areContinuous(AccessionNumber o){
        return alphaString.equals(o.alphaString) && digits == o.digits && Math.abs(number - o.number) == 1;
    }

    public String getOriginal(){
        return original;
    }

}