package com.gohealth.gohealth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rameshkulkarni on 9/4/17.
 */
@Controller
public class HomeController
{
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
