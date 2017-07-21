package com.pck.afsilva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class to sort and find ranges for a list of Accession Numbers
 *
 * @author afsilva
 */
public class AccessionNumberSummarized {

    public AccessionNumberSummarized() {
    }

    public String processAccessionNumbers(String accNumStr){
        String accNumNoSpaces = accNumStr.replaceAll("\\s+","");
        List<AccessionNumber> accNumList = Arrays.stream(accNumNoSpaces.split(","))
                .map(s -> new AccessionNumber(s))
                .collect(Collectors.toList());
        Collections.sort(accNumList);
        return findRangesString(accNumList);
    }

    private String findRangesString(List<AccessionNumber> accNumList){
        StringBuilder builder = new StringBuilder();
        int size = accNumList.size();
        int i = 0;
        while (i < size){
            AccessionNumber current = accNumList.get(i);

            if (i == 0 || !current.areContinuous(accNumList.get(i - 1))){
                builder.append(", ").append(current.getOriginal());
            }
            else if (current.areContinuous(accNumList.get(i - 1)) &&
                    (i == size - 1 || !accNumList.get(i).areContinuous(accNumList.get(i + 1)))){
                builder.append("-");
                builder.append(current.getOriginal());
            }
            i++;
        }

        String result = builder.toString();
        return result.substring(2, result.length());
    }

}
