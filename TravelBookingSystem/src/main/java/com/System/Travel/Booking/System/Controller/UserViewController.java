package com.System.Travel.Booking.System.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping(path={"","home","welcome","index"})
    public String welcomeView(){
        return "index";
    }

    @GetMapping("about")
    public String aboutView(){
        return "about";
    }

    @GetMapping("flights")
    public String flightsView(){
        return "flights";
    }

    @GetMapping("hotels")
    public String hotelsView(){
        return "hotels";
    }
    @GetMapping("transports")
    public String transportsView(){
        return "transports";
    }

    @GetMapping("services")
    public String serviceView(){
        return "services";
    }

    @GetMapping("contacts")
    public String contactView(){
        return "contacts";
    }

}

