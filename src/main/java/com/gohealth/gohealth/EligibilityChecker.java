package com.gohealth.gohealth;

import org.springframework.web.client.RestTemplate;

/**
 * Created by rameshkulkarni on 9/6/17.
 */
public class EligibilityChecker
{
    public static final String ELIGIBILITY_API_URL = "https://apistage.gohealthuc.com:1981/v1/eligibility_demo";
    public static final String NPI_PROVIDER = "1234567890";


    public void getEligibility(Registration registration) throws Exception
    {
        JWTAuthentication auth = new JWTAuthentication();
        String authToken = auth.getJWTToken();

        RestTemplate restTemplate = new RestTemplate();


    }
}
