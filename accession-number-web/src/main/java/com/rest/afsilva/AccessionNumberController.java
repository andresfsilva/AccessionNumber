package com.rest.afsilva;

import com.pck.afsilva.AccessionNumberSummarized;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for spring boot application
 *
 * @author afsilva
 */
@RestController
public class AccessionNumberController {

    private final AccessionNumberSummarized accNumSum;

    public AccessionNumberController(AccessionNumberSummarized accNumSum){
        this.accNumSum = accNumSum;
    }

    @RequestMapping("/accession_number")
    public String accessionNumbers(@RequestParam(value="accNumStr") String accNumStr){
        return accNumSum.processAccessionNumbers(accNumStr);
    }
}

