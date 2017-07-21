package com.rest.afsilva;

import com.pck.afsilva.AccessionNumberSummarized;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring boot application class
 *
 * @author afsilva
 */
@SpringBootApplication
public class AccessionNumberWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccessionNumberWebApplication.class, args);
    }

    @Bean
    public AccessionNumberSummarized getAccessionNumberSumarized(){
        return new AccessionNumberSummarized();
    }
}