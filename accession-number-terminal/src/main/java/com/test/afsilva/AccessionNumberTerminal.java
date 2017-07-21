package com.test.afsilva;

import com.pck.afsilva.AccessionNumberSummarized;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Provides the main method to process an Accession Number list
 *
 * @author afsilva
 */
@SpringBootApplication
public class AccessionNumberTerminal {

    @Bean
    public AccessionNumberSummarized getAccessionNumberSumarized(){
        return new AccessionNumberSummarized();
    }

    @Bean
    public CommandLineRunner getCommandLineRunner(AccessionNumberSummarized accNumSum){
        return new AccessionNumberCommandLineRunner(accNumSum);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AccessionNumberTerminal.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
