package com.gohealth.gohealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.ArrayList;

/**
 * Created by rameshkulkarni on 9/4/17.
 */
@RestController
@RequestMapping(value="/api/registrations")
public class RegistrationRestController
{

    @Autowired
    private RegistrationRepository rr;

    public RegistrationRestController()
    {

    }


    @RequestMapping("/all")
    Collection<Registration> getAllRegistrations()
    {
        ArrayList<Registration> registrations = new ArrayList<Registration>();
        rr.findAll().forEach(n -> registrations.add(n));
        return registrations;
    }

    @PostMapping(value="/save")
    @CrossOrigin(origins = "http://localhost:3000")
    public void saveRegistration(@RequestBody final Registration registration)
    {
        System.out.println(registration);
        rr.save(registration);
    }


}
