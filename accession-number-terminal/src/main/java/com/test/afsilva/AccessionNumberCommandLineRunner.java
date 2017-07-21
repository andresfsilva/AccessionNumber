package com.test.afsilva;

import com.pck.afsilva.AccessionNumberSummarized;
import org.springframework.boot.CommandLineRunner;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Implements command line runner to be used as a dependency
 *
 * @author afsilva
 */
public class AccessionNumberCommandLineRunner implements CommandLineRunner {

    private final AccessionNumberSummarized accNumSum;

    public AccessionNumberCommandLineRunner(AccessionNumberSummarized accNumSum) {
        this.accNumSum = accNumSum;
    }

    @Override
    public void run(String... args) throws Exception {
        String result = accNumSum.processAccessionNumbers(Arrays.asList(args).stream().collect(Collectors.joining()));
        System.out.println(result);
    }
}
